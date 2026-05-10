# Example SQL Injection Testing

test_inputs = [
    "' OR '1'='1",
    "admin' --",
    "'; DROP TABLE users; --",
    "<script>alert('xss')</script>"
]

blocked_keywords = ["DROP", "--", "<script>", " OR "]

def detect_sql_injection(user_input):
    for keyword in blocked_keywords:
        if keyword.lower() in user_input.lower():
            return True
    return False


for payload in test_inputs:
    if detect_sql_injection(payload):
        print(f"[BLOCKED] Malicious input detected: {payload}")
    else:
        print(f"[SAFE] {payload}")
