package com.huyhoang.swing.model;

import com.huyhoang.swing.event.EventPopupMenu;
import java.awt.Frame;

public class ModelMore {
    private Object obj;
    private Frame frame;

    public ModelMore(Object obj, Frame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    public ModelMore() {
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    
}
