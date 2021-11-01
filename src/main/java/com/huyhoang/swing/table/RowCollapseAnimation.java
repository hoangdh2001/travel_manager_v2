package com.huyhoang.swing.table;

import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class RowCollapseAnimation {
    private final MigLayout layout;
    private final RowTable row;
    private Animator animator;
    private boolean open;
    private int rowHeight;
    private int duration;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getRowHeight() {
        return rowHeight;
    }

    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public RowCollapseAnimation(MigLayout layout, RowTable row, int rowHeight) {
        this.layout = layout;
        this.row = row;
        this.rowHeight = rowHeight;
        this.duration = 200;
        initAnimator();
    }
    
    public RowCollapseAnimation(MigLayout layout, RowTable row, int rowHeight, int duration) {
        this.layout = layout;
        this.row = row;
        this.rowHeight = rowHeight;
        this.duration = duration;
        initAnimator();
    }
    
    private void initAnimator() {
        int height = row.getPreferredSize().height;
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float h;
                int shadowSize;
                float opacity;
                if(open) {
                    h = rowHeight + ((height - rowHeight) * fraction);
                    shadowSize = (int) (2 + ((5 - 2)) * fraction);
                    opacity = (float) (0.3 + ((0.5 - 0.3) * fraction));
                } else {
                    h = rowHeight + ((height - rowHeight) * (1f - fraction));
                    shadowSize = (int) (2 + ((5 - 2)) * (1f - fraction));
                    opacity = (float) (0.3 + ((0.5 - 0.3) * (1f - fraction)));
                }
                row.setShadowSize(shadowSize);
                row.setShadowOpacity(opacity);
                layout.setComponentConstraints(row, "h " + h + "!");
                row.revalidate();
                row.repaint();
            }
        };
        animator = new Animator(duration, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
    }
    
    public void openMenu() {
        open = true;
        if(!animator.isRunning()) {
            animator.start();
        }
    }
    
    public void closeMenu() {
        open = false;
        if(!animator.isRunning()) {
            animator.start();
        }
    }
}
