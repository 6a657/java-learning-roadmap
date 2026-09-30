package com.example.oop;

import java.math.BigDecimal;

public class Main {
    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testUser();
        testBankAccount();
        System.out.printf("%n===== Answer: passed=%d, failed=%d =====%n", passed, failed);
    }

    // test User
    private static void testUser() {
        System.out.println("--- User Test ---");
        User u1 = new User("Alice", "alice@example.com");
        User u2 = new User("Bob", "bob@example.com");
        check("id inc", u1.getId() < u2.getId());
        check("toString has email", u1.toString().contains("alice@example.com"));

        expectThrows("Illegal email and throw IAE",
            () -> u1.setEmail("not-an-email"),
            IllegalArgumentException.class
        );

        expectThrows("blank username and throw IAE",
            () -> new User("", "x@y.com"),
            IllegalArgumentException.class
        );
    }

    // test BankAccount
    private static void testBankAccount() {
        System.out.println("---- Test BankAccount and 8 cases ----");
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal fifty = new BigDecimal("50");
        BigDecimal thousand = new BigDecimal("1000");
        BigDecimal minusTen = new BigDecimal("-10");

        BankAccount a = new BankAccount("A001", zero);
        a.deposit(hundred);
        check("1. deposit 100 then total num is 100", a.getBalance().compareTo(hundred) == 0);

        a.withdraw(fifty);
        check("2. withdraw 50 then total num is 50", a.getBalance().compareTo(fifty) == 0);

        expectThrows("3. take much money then throw error",
            () -> a.withdraw(thousand),
            IllegalStateException.class
        );

        expectThrows("4. deposit -10 money then throw error",
            () -> a.deposit(minusTen),
            IllegalArgumentException.class
        );

        expectThrows("5. take 0 money then throw error",
            () -> a.withdraw(zero),
            IllegalArgumentException.class
        );

        a.freeze();
        expectThrows("6. freeze state, take money then throw error",
            () -> a.withdraw(fifty),
            IllegalStateException.class
        );

        expectThrows("7. freeze state, deposit money then throw error",
            () -> a.deposit(fifty),
            IllegalStateException.class
        );

        a.unfreeze();
        a.withdraw(fifty);
        check("8. unfreeze then withdraw successfully, there's no money",
            a.getBalance().compareTo(zero) == 0
        );
        expectThrows("9. there's no money, try to withdraw then throw ISE",
            () -> a.withdraw(fifty),
            IllegalStateException.class
        );
    }

    private static void check(String name, boolean ok){
        if(ok) {passed++; System.out.println("[PASS] "+name);}
        else {failed++; System.out.println("[FAIL] "+name);}
    }

    private static void expectThrows(String name, Runnable r, Class<? extends Throwable> type){
        try {
            r.run();
            failed++;
            System.out.println("[FAIL] "+name+" (can't throw error)");
        } catch(Throwable t){
            if (type.isInstance(t)){
                passed++;
                System.out.println("[PASS] "+name+" -> "+t.getClass().getSimpleName());
            } else {
                failed++;
                System.out.println("[FAIL] "+name+" throw "+t.getClass().getSimpleName());
            }
        }
    }
}