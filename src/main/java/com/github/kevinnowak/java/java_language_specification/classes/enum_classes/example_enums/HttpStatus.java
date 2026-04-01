package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.example_enums;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A sophisticated Java enum showcasing ALL major enum capabilities:
 * <p>
 * 1. Fields & constructor overloading
 * 2. Interface implementation
 * 3. Abstract methods (constant-specific body)
 * 4. Method overriding per constant
 * 5. Static factory methods & caches
 * 6. Instance methods
 * 7. EnumSet / EnumMap usage
 * 8. Nested enum
 * 9. Functional filtering (Predicate)
 * 10. Custom toString / fromString round-trip
 * 11. Comparable (natural ordering by declaration)
 * 12. Serializable (built-in)
 */
public enum HttpStatus implements Comparable<HttpStatus> {

    // ──────────────────────────────────────────────
    // 1xx — Informational
    // ──────────────────────────────────────────────
    CONTINUE(100, "Continue", Family.INFORMATIONAL) {
        @Override
        public String suggestAction() {
            return "Client should continue with the request body.";
        }
    },

    SWITCHING_PROTOCOLS(101, "Switching Protocols", Family.INFORMATIONAL) {
        @Override
        public String suggestAction() {
            return "Upgrade the connection (e.g. to WebSocket).";
        }
    },

    // ──────────────────────────────────────────────
    // 2xx — Success
    // ──────────────────────────────────────────────
    OK(200, "OK", Family.SUCCESS) {
        @Override
        public String suggestAction() {
            return "Process the response body normally.";
        }
    },

    CREATED(201, "Created", Family.SUCCESS) {
        @Override
        public String suggestAction() {
            return "Read the Location header for the new resource URI.";
        }
    },

    NO_CONTENT(204, "No Content", Family.SUCCESS) {
        @Override
        public String suggestAction() {
            return "No body expected — update local state only.";
        }
    },

    // ──────────────────────────────────────────────
    // 3xx — Redirection
    // ──────────────────────────────────────────────
    MOVED_PERMANENTLY(301, "Moved Permanently", Family.REDIRECTION) {
        @Override
        public String suggestAction() {
            return "Update bookmarks; follow the Location header permanently.";
        }
    },

    FOUND(302, "Found", Family.REDIRECTION) {
        @Override
        public String suggestAction() {
            return "Follow the Location header for this request only.";
        }
    },

    NOT_MODIFIED(304, "Not Modified", Family.REDIRECTION) {
        @Override
        public String suggestAction() {
            return "Use the cached version of the resource.";
        }
    },

    // ──────────────────────────────────────────────
    // 4xx — Client Error
    // ──────────────────────────────────────────────
    BAD_REQUEST(400, "Bad Request", Family.CLIENT_ERROR) {
        @Override
        public String suggestAction() {
            return "Fix the malformed request syntax and retry.";
        }
    },

    UNAUTHORIZED(401, "Unauthorized", Family.CLIENT_ERROR) {
        @Override
        public String suggestAction() {
            return "Provide or refresh authentication credentials.";
        }

        // ── Per-constant method override ──
        @Override
        public boolean isSecurityRelated() {
            return true;
        }
    },

    FORBIDDEN(403, "Forbidden", Family.CLIENT_ERROR) {
        @Override
        public String suggestAction() {
            return "Escalate privileges or contact an administrator.";
        }

        @Override
        public boolean isSecurityRelated() {
            return true;
        }
    },

    NOT_FOUND(404, "Not Found", Family.CLIENT_ERROR) {
        @Override
        public String suggestAction() {
            return "Verify the URL; the resource may have been removed.";
        }
    },

    METHOD_NOT_ALLOWED(405, "Method Not Allowed", Family.CLIENT_ERROR) {
        @Override
        public String suggestAction() {
            return "Check the Allow response header for permitted methods.";
        }
    },

    TOO_MANY_REQUESTS(429, "Too Many Requests", Family.CLIENT_ERROR) {
        @Override
        public String suggestAction() {
            return "Back off and honour the Retry-After header.";
        }

        // ── Another per-constant override ──
        @Override
        public boolean isRetryable() {
            return true;
        }
    },

    // ──────────────────────────────────────────────
    // 5xx — Server Error
    // ──────────────────────────────────────────────
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", Family.SERVER_ERROR) {
        @Override
        public String suggestAction() {
            return "Log the error and retry with exponential back-off.";
        }

        @Override
        public boolean isRetryable() {
            return true;
        }
    },

    BAD_GATEWAY(502, "Bad Gateway", Family.SERVER_ERROR) {
        @Override
        public String suggestAction() {
            return "Retry — the upstream server may recover.";
        }

        @Override
        public boolean isRetryable() {
            return true;
        }
    },

    SERVICE_UNAVAILABLE(503, "Service Unavailable", Family.SERVER_ERROR) {
        @Override
        public String suggestAction() {
            return "Wait for the Retry-After period, then retry.";
        }

        @Override
        public boolean isRetryable() {
            return true;
        }
    },

    GATEWAY_TIMEOUT(504, "Gateway Timeout", Family.SERVER_ERROR) {
        @Override
        public String suggestAction() {
            return "Retry — the upstream server timed out.";
        }

        @Override
        public boolean isRetryable() {
            return true;
        }
    };

    // ══════════════════════════════════════════════
    //  NESTED ENUM — Status Family
    // ══════════════════════════════════════════════
    public enum Family {
        INFORMATIONAL("1xx"),
        SUCCESS("2xx"),
        REDIRECTION("3xx"),
        CLIENT_ERROR("4xx"),
        SERVER_ERROR("5xx");

        private final String label;

        Family(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    // ══════════════════════════════════════════════
    //  FIELDS & CONSTRUCTOR
    // ══════════════════════════════════════════════
    private final int code;
    private final String reason;
    private final Family family;

    // Static lookup cache (code → enum), built once
    private static final Map<Integer, HttpStatus> BY_CODE;

    static {
        // EnumMap isn't suitable here (key is Integer), but we
        // still demonstrate EnumSet / EnumMap further below.
        Map<Integer, HttpStatus> map = new HashMap<>();
        for (HttpStatus s : values()) {
            map.put(s.code, s);
        }
        BY_CODE = Collections.unmodifiableMap(map);
    }

    // Private constructor (enums can't be public-constructed)
    HttpStatus(int code, String reason, Family family) {
        this.code = code;
        this.reason = reason;
        this.family = family;
    }

    // ══════════════════════════════════════════════
    //  ABSTRACT METHOD — every constant MUST implement
    // ══════════════════════════════════════════════

    /**
     * Returns a developer-friendly recommended action.
     */
    public abstract String suggestAction();

    // ══════════════════════════════════════════════
    //  INSTANCE METHODS (with overridable defaults)
    // ══════════════════════════════════════════════
    public int code() {
        return code;
    }

    public String reason() {
        return reason;
    }

    public Family family() {
        return family;
    }

    /**
     * Override in security-sensitive constants.
     */
    public boolean isSecurityRelated() {
        return false;
    }

    /**
     * Override in constants where a retry makes sense.
     */
    public boolean isRetryable() {
        return false;
    }

    public boolean isSuccess() {
        return family == Family.SUCCESS;
    }

    public boolean isClientError() {
        return family == Family.CLIENT_ERROR;
    }

    public boolean isServerError() {
        return family == Family.SERVER_ERROR;
    }

    public boolean isError() {
        return isClientError() || isServerError();
    }

    // ══════════════════════════════════════════════
    //  STATIC FACTORY / LOOKUP METHODS
    // ══════════════════════════════════════════════

    /**
     * O(1) lookup by numeric code.
     */
    public static HttpStatus fromCode(int code) {
        HttpStatus status = BY_CODE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("Unknown HTTP status code: " + code);
        }
        return status;
    }

    /**
     * Case-insensitive reverse lookup:  "not_found" → NOT_FOUND
     */
    public static HttpStatus fromString(String name) {
        return valueOf(name.toUpperCase(Locale.ROOT));
    }

    /**
     * Predicate-based filtering across all constants.
     */
    public static List<HttpStatus> matching(Predicate<HttpStatus> filter) {
        return Arrays.stream(values())
                .filter(filter)
                .collect(Collectors.toUnmodifiableList());
    }

    // ══════════════════════════════════════════════
    //  toString / DISPLAY
    // ══════════════════════════════════════════════
    @Override
    public String toString() {
        return code + " " + reason;
    }

    /**
     * Compact summary for logging.
     */
    public String toDebugString() {
        return String.format("[%s] %d %s | retryable=%b security=%b | hint: %s",
                family.label(), code, reason, isRetryable(), isSecurityRelated(),
                suggestAction());
    }

    // ══════════════════════════════════════════════
    //  DEMO — EnumSet, EnumMap, streaming, switch
    // ══════════════════════════════════════════════
    public static void main(String[] args) {

        System.out.println("═══ 1. Basic usage ═══");
        HttpStatus status = HttpStatus.NOT_FOUND;
        System.out.println("Status  : " + status);            // toString()
        System.out.println("Code    : " + status.code());
        System.out.println("Family  : " + status.family());
        System.out.println("Action  : " + status.suggestAction());
        System.out.println("Error?  : " + status.isError());
        System.out.println();

        // ── Static factory from int ──
        System.out.println("═══ 2. Lookup by code ═══");
        HttpStatus fromInt = HttpStatus.fromCode(503);
        System.out.println("fromCode(503) → " + fromInt.toDebugString());
        System.out.println();

        // ── Reverse lookup from string ──
        System.out.println("═══ 3. Reverse lookup ═══");
        HttpStatus fromStr = HttpStatus.fromString("bad_request");
        System.out.println("fromString(\"bad_request\") → " + fromStr);
        System.out.println();

        // ── Switch expression (Java 14+) ──
        System.out.println("═══ 4. Switch on enum ═══");
        String emoji = switch (status) {
            case OK, CREATED, NO_CONTENT -> "✅";
            case MOVED_PERMANENTLY, FOUND -> "➡️";
            case UNAUTHORIZED, FORBIDDEN -> "🔒";
            case NOT_FOUND -> "❓";
            case TOO_MANY_REQUESTS -> "🐌";
            case INTERNAL_SERVER_ERROR, BAD_GATEWAY,
                 SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT -> "🔥";
            default -> "ℹ️";
        };
        System.out.println(status + " → " + emoji);
        System.out.println();

        // ── EnumSet: fast bitfield-backed set ──
        System.out.println("═══ 5. EnumSet — retryable statuses ═══");
        EnumSet<HttpStatus> retryable = EnumSet.noneOf(HttpStatus.class);
        for (HttpStatus s : HttpStatus.values()) {
            if (s.isRetryable()) retryable.add(s);
        }
        retryable.forEach(s -> System.out.println("  • " + s));
        System.out.println();

        // ── EnumMap: enum-keyed map ──
        System.out.println("═══ 6. EnumMap — hit counters per family ═══");
        EnumMap<Family, Integer> hitsByFamily = new EnumMap<>(Family.class);
        for (Family f : Family.values()) hitsByFamily.put(f, 0);
        // Simulate some hits
        List<HttpStatus> traffic = List.of(OK, OK, CREATED, NOT_FOUND,
                UNAUTHORIZED, INTERNAL_SERVER_ERROR, OK, BAD_GATEWAY);
        for (HttpStatus s : traffic) {
            hitsByFamily.merge(s.family(), 1, Integer::sum);
        }
        hitsByFamily.forEach((fam, count) ->
                System.out.printf("  %-15s → %d hits%n", fam, count));
        System.out.println();

        // ── Predicate-based filtering ──
        System.out.println("═══ 7. Predicate filter — security-related ═══");
        List<HttpStatus> secure = HttpStatus.matching(HttpStatus::isSecurityRelated);
        secure.forEach(s -> System.out.println("  🔒 " + s));
        System.out.println();

        // ── Comparable: natural declaration order ──
        System.out.println("═══ 8. Comparable — sorted by declaration ═══");
        List<HttpStatus> shuffled = new ArrayList<>(List.of(
                GATEWAY_TIMEOUT, OK, UNAUTHORIZED, CONTINUE));
        Collections.sort(shuffled);           // uses ordinal order
        shuffled.forEach(s -> System.out.println("  " + s.ordinal() + ". " + s));
        System.out.println();

        // ── Full catalogue with debug strings ──
        System.out.println("═══ 9. Full catalogue ═══");
        for (HttpStatus s : HttpStatus.values()) {
            System.out.println(s.toDebugString());
        }
    }
}
