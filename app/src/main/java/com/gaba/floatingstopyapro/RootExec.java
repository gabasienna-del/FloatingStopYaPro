package com.gaba.floatingstopyapro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RootExec {
    public static boolean run(String cmd) {
        Process p = null;
        try {
            p = new ProcessBuilder("su", "-c", cmd).redirectErrorStream(true).start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (in.readLine() != null) { /* consume */ }
            int code = p.waitFor();
            return code == 0;
        } catch (Throwable t) {
            return false;
        } finally {
            if (p != null) p.destroy();
        }
    }
}
