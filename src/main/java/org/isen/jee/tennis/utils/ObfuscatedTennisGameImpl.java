package org.isen.jee.tennis.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.isen.jee.tennis.TennisGame;

import biz.source_code.base64Coder.Base64Coder;
/**
 * Cette classe implémente presque correctement TennisGame (la règle
 * de l'avantage n'est pas complètement implémentée.
 * Vous pouvez l'utiliser pour la partie 2 (servlet) si vous
 * n'avez pas réussi la partie 1.
 *
 * Ne perdez pas votre temps à comprendre ce qu'il y a dedans,
 * le code est volontairement très complexe à comprendre.
 *
 * @author dmetzler
 *
 */
public class ObfuscatedTennisGameImpl implements TennisGame {

    private static final String[] STRINGS = new String[] { "J", "F" };
	private static final String EZ = "ez";
    private static final String BLA = "rO0ABXVyABRbW0xqYXZhLmxhbmcuU3RyaW5nOzJNCa2EM"
            + "uRXAgAAeHAAAAAGdXIAE1tMamF2YS5sYW5nLlN0cmluZzut0lbn6R17RwIAAHhwAAAABX"
            + "QACTAgcGFydG91dHQABDAtMTV0AAQwLTMwdAAEMC00MHQAEHsyfSBnYWduZSBsZSBqZXV1"
            + "cQB+AAIAAAAFdAAEMTUtMHQACjE1IHBhcnRvdXR0AAUxNS0zMHQABTE1LTQwcQB+AAh1cQ"
            + "B+AAIAAAAFdAAEMzAtMHQABTMwLTE1dAAKMzAgcGFydG91dHQABTMwLTQwcQB+AAh1cQB+"
            + "AAIAAAAGdAAENDAtMHQABTQwLTE1dAAFNDAtMzB0AAhFZ2FsaXTDqXQADEF2YW50YWdlIH"
            + "syfXEAfgAIdXEAfgACAAAABHQAEHsxfSBnYWduZSBsZSBqZXVxAH4AGnEAfgAadAAMQXZh"
            + "bnRhZ2UgezF9dXEAfgACAAAABHEAfgAacQB+ABpxAH4AGnEAfgAa";

    private static final String F = "getPlayer{0}Name";

    private enum ANENUMTHATISNOTVERYIMPORTANT {
        SIMPLEVALUE("1"), VERYCOMPLICATEDVALUETOCRYPTHATAWFULBLOB("2");
        private String f;

        private ANENUMTHATISNOTVERYIMPORTANT(String i) {
            f = i;
        }

        public ANENUMTHATISNOTVERYIMPORTANT x(int i) {
            for (ANENUMTHATISNOTVERYIMPORTANT z : ANENUMTHATISNOTVERYIMPORTANT
                    .values()) {
                if (z.f.equals(String.format("%d", i))) {
                    return z;
                }
            }
            return SIMPLEVALUE;
        }

        public String value() {
            return f;
        }
    }

    private Map<String, Integer> rules = new HashMap<>();
    private final String p1;
    private final String p2;

    public ObfuscatedTennisGameImpl(String _1, String _2) {
        this.p1 = _1;
        this.p2 = _2;
        try {
            rules.put("F", 1);
            ref = ((String[][]) fromString(BLA))[0][0];
            rules.put("J", 2);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getScore() {
        String score = ref;
        for (String s : STRINGS) {
            try {
                Method method = getClass().getMethod(F.replace(b("B"),
                        ANENUMTHATISNOTVERYIMPORTANT.SIMPLEVALUE.x(rules.get(s))
                        .value()));
                score = score.replace(b(s), (String) method.invoke(this));

            } catch (Exception e) {
            }
        }
        return score;
    }

    private String ref;

    public String b(String a) {
        return new String(Base64.decodeBase64(EZ + a + "9"));
    }

    @Override
    public void player1Scores() {
        scores(ANENUMTHATISNOTVERYIMPORTANT.SIMPLEVALUE);
    }

    private void scores(ANENUMTHATISNOTVERYIMPORTANT player) {
        if (!isEnded()) {
            boolean a = false;
            try {
                for (int simpleiterator = 0; simpleiterator < ((String[][]) fromString(BLA)).length
                        && !a; simpleiterator++) {
                    for (int newone = 0; newone < ((String[][]) fromString(BLA))[simpleiterator].length
                            && !a; newone++) {
                        if (((String[][]) fromString(BLA))[simpleiterator][newone]
                                .equals(ref)) {
                            ref = player == ANENUMTHATISNOTVERYIMPORTANT.SIMPLEVALUE ? ((String[][]) fromString(BLA))[simpleiterator + 1][newone]
                                    : ((String[][]) fromString(BLA))[simpleiterator][newone + 1];
                            ;
                            a = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {

            }
        }

    }

    @Override
    public void player2Scores() {
        scores(ANENUMTHATISNOTVERYIMPORTANT.VERYCOMPLICATEDVALUETOCRYPTHATAWFULBLOB);
    }

    @Override
    public boolean isEnded() {
        return getScore().contains("gagne le jeu");
    }

    @Override
    public String getPlayer1Name() {
        return p1;
    }

    @Override
    public String getPlayer2Name() {
        return p2;
    }

    private static Object fromString(String s) throws IOException,
            ClassNotFoundException {
        byte[] data = Base64Coder.decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
                data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

}
