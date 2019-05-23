package com.wangzijie.nutrition_user.utils;

public class StatusHolder {
    private static StatusHolder mInstance;
    private boolean isKill = true;

    private StatusHolder() {

    }

    public synchronized static StatusHolder getInstance() {
        if (mInstance == null) {
            synchronized (StatusHolder.class) {
                if (mInstance == null) {
                    mInstance = new StatusHolder();
                }
            }
        }
        return mInstance;
    }

    public boolean isKill() {
        return isKill;
    }

    public void setKill(boolean kill) {
        isKill = kill;
    }
}



