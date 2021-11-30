package com.hoanghung.swing.model;

import com.hoanghung.swing.event.EventAction;

public class ModelAction {
    private EventAction event;
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(Object o, EventAction event) {
        this.obj = o;
        this.event = event;
    }

    public ModelAction() {
    }
}
