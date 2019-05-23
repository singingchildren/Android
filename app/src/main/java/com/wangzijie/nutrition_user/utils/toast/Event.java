package com.wangzijie.nutrition_user.utils.toast;

import java.util.ArrayList;
import java.util.List;

public class Event{
    public int id;
    public String content;

    public Event(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
