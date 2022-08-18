package com.alvonellos.interview.util.java;

public class AddressUtil {
    /**
     * Utility function to get the address of an object
     * @param o
     * @return
     */
    public static String addrString(Object o) {
        return o == null ? "null" : o.getClass().getName() + "@" +
                Integer.toHexString(System.identityHashCode(o));
    }
}
