package org.step.first;

import org.step.first.service.AccessGr;

public class AboutJava {

    private AccessGr accessGr;

    public void printRelease(int i) {
        System.out.println("Java " + i + " LTS");
    }

    public AccessGr getAboutJava() {
        return accessGr;
    }

    public void setAboutJava(AccessGr accessGr) {
        this.accessGr = accessGr;
    }
}
