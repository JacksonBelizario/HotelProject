/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.ui;

import com.formdev.flatlaf.ui.FlatTabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;


public class CenterTabbedPane extends FlatTabbedPaneUI {

    @Override
    protected LayoutManager createLayoutManager() {
        return new TabbedPaneLayout();
    }

    class TabbedPaneLayout extends BasicTabbedPaneUI.TabbedPaneLayout {

        private Insets getVisualMargin() {
            Insets margin = new Insets(3, 0, 3, 0);
            return add(-3, -3, -4, -3, margin);
        }

        @Override
        protected void calculateTabRects(int tabPlacement, int tabCount) {
            Dimension size = tabPane.getSize();
            Insets insets = add(tabPane.getInsets(), getVisualMargin());
            Insets tabAreaInsets = getTabAreaInsets(tabPlacement);
            FontMetrics metrics = getFontMetrics();
            int fontHeight = metrics.getHeight();
            int selectedIndex = tabPane.getSelectedIndex();
            int tabRunOverlay;
            int i, j;
            int x, y;
            int returnAt;
            boolean verticalTabRuns = (tabPlacement == LEFT || tabPlacement == RIGHT);

            //
            // Calculate bounds within which a tab run must fit
            //
            switch (tabPlacement) {
                case LEFT:
                    maxTabWidth = calculateMaxTabWidth(tabPlacement);
                    x = insets.left + tabAreaInsets.left;
                    y = insets.top + tabAreaInsets.top;
                    returnAt = size.height - (insets.bottom + tabAreaInsets.bottom);
                    break;
                case RIGHT:
                    maxTabWidth = calculateMaxTabWidth(tabPlacement);
                    x = size.width - insets.right - tabAreaInsets.right - maxTabWidth;
                    y = insets.top + tabAreaInsets.top;
                    returnAt = size.height - (insets.bottom + tabAreaInsets.bottom);
                    break;
                case BOTTOM:
                    maxTabHeight = calculateMaxTabHeight(tabPlacement);
                    x = insets.left + tabAreaInsets.left;
                    y = size.height - insets.bottom - tabAreaInsets.bottom - maxTabHeight;
                    returnAt = size.width - (insets.right + tabAreaInsets.right);
                    break;
                case TOP:
                default:
                    maxTabHeight = calculateMaxTabHeight(tabPlacement);
                    x = insets.left + tabAreaInsets.left;
                    y = insets.top + tabAreaInsets.top;
                    returnAt = size.width - (insets.right + tabAreaInsets.right);
                    break;
            }

            tabRunOverlay = getTabRunOverlay(tabPlacement);

            runCount = 0;
            selectedRun = -1;

            if (tabCount == 0) {
                return;
            }

            // Run through tabs and partition them into runs
            Rectangle rect;
            for (i = 0; i < tabCount; i++) {
                rect = rects[i];

                if (!verticalTabRuns) {
                    // Tabs on TOP or BOTTOM....
                    if (i > 0) {
                        rect.x = rects[i - 1].x + rects[i - 1].width;
                    } else {
                        tabRuns[0] = 0;
                        runCount = 1;
                        maxTabWidth = 0;
                        rect.x = x;
                    }
                    rect.width = calculateTabWidth(tabPlacement, i, metrics);
                    maxTabWidth = Math.max(maxTabWidth, rect.width);

                    // Never move a TAB down a run if it is in the first column.
                    // Even if there isn't enough room, moving it to a fresh
                    // line won't help.
                    if (rect.x != 2 + insets.left && rect.x + rect.width > returnAt) {
                        if (runCount > tabRuns.length - 1) {
                            expandTabRunsArray();
                        }
                        tabRuns[runCount] = i;
                        runCount++;
                        rect.x = x;
                    }
                    // Initialize y position in case there's just one run
                    rect.y = y;
                    rect.height = maxTabHeight/* - 2*/;

                } else {
                    // Tabs on LEFT or RIGHT...
                    if (i > 0) {
                        rect.y = rects[i - 1].y + rects[i - 1].height;
                    } else {
                        tabRuns[0] = 0;
                        runCount = 1;
                        maxTabHeight = 0;
                        rect.y = y;
                    }
                    rect.height = calculateTabHeight(tabPlacement, i, fontHeight);
                    maxTabHeight = Math.max(maxTabHeight, rect.height);

                    // Never move a TAB over a run if it is in the first run.
                    // Even if there isn't enough room, moving it to a fresh
                    // column won't help.
                    if (rect.y != 2 + insets.top && rect.y + rect.height > returnAt) {
                        if (runCount > tabRuns.length - 1) {
                            expandTabRunsArray();
                        }
                        tabRuns[runCount] = i;
                        runCount++;
                        rect.y = y;
                    }
                    // Initialize x position in case there's just one column
                    rect.x = x;
                    rect.width = maxTabWidth/* - 2*/;

                }
                if (i == selectedIndex) {
                    selectedRun = runCount - 1;
                }
            }

            if (runCount > 1) {
                // Re-distribute tabs in case last run has leftover space
                normalizeTabRuns(tabPlacement, tabCount, verticalTabRuns ? y : x, returnAt);

                selectedRun = getRunForTab(tabCount, selectedIndex);

                // Rotate run array so that selected run is first
                if (shouldRotateTabRuns(tabPlacement)) {
                    rotateTabRuns(tabPlacement, selectedRun);
                }
            }

            // Determine how much we want to pad the tabs
            int maxPad = 0;
            /*
            for (i = runCount - 1; i >= 0; i--) {
            int start = tabRuns[i];
            int next = tabRuns[i == (runCount - 1)? 0 : i + 1];
            int end = (next != 0? next - 1 : tabCount - 1);

            maxPad = Math.max(maxPad, rects[end].x + rects[end].width - rects[start].x);
            }*/
            switch (tabPlacement) {
                case LEFT:
                case RIGHT:
                    maxPad = size.height - tabAreaInsets.top - tabAreaInsets.bottom;
                    break;
                case BOTTOM:
                case TOP:
                default:
                    maxPad = size.width - tabAreaInsets.left - tabAreaInsets.right;
                    break;
            }

            // Step through runs from back to front to calculate
            // tab y locations and to pad runs appropriately
            for (i = runCount - 1; i >= 0; i--) {
                int start = tabRuns[i];
                int next = tabRuns[i == (runCount - 1) ? 0 : i + 1];
                int end = (next != 0 ? next - 1 : tabCount - 1);
                if (!verticalTabRuns) {
                    for (j = start; j <= end; j++) {
                        rect = rects[j];
                        rect.y = y;
                        rect.x += getTabRunIndent(tabPlacement, i);
                    }
                    if (shouldPadTabRun(tabPlacement, i)) {
                        padTabRun(tabPlacement, start, end, maxPad);
                    }
                    if (tabPlacement == BOTTOM) {
                        y -= (maxTabHeight - tabRunOverlay);
                    } else {
                        y += (maxTabHeight - tabRunOverlay);
                    }
                } else {
                    for (j = start; j <= end; j++) {
                        rect = rects[j];
                        rect.x = x;
                        rect.y += getTabRunIndent(tabPlacement, i);
                    }
                    if (shouldPadTabRun(tabPlacement, i)) {
                        padTabRun(tabPlacement, start, end, maxPad);
                    }
                    if (tabPlacement == RIGHT) {
                        x -= (maxTabWidth - tabRunOverlay);
                    } else {
                        x += (maxTabWidth - tabRunOverlay);
                    }
                }
            }

            // Pad the selected tab so that it appears raised in front
            padSelectedTab(tabPlacement, selectedIndex);

            // if right to left and tab placement on the top or
            // the bottom, flip x positions and adjust by widths
            if (verticalTabRuns) {
                int rightMargin = size.width - (insets.right + tabAreaInsets.right);
                for (i = 0; i < tabCount; i++) {
                    rects[i].x = rightMargin - rects[i].x - rects[i].width;
                }
            }


            switch (tabPlacement) {
                case LEFT:
                case RIGHT: {
                    int availableTabAreaHeight = size.height - insets.top - insets.bottom - tabAreaInsets.top - tabAreaInsets.bottom;
                    int usedTabAreaHeight = 0;
                    int pad = 0;
                    for (int run = 0; run < runCount; run++) {
                        int firstIndex = tabRuns[run];
                        int lastIndex = lastTabInRun(tabCount, run);
                        if (run == 0) {
                            usedTabAreaHeight = 0;
                            for (i = firstIndex; i <= lastIndex; i++) {
                                usedTabAreaHeight += rects[i].height;
                            }
                            pad = (availableTabAreaHeight - usedTabAreaHeight) / 2;
                        }
                        for (i = firstIndex; i <= lastIndex; i++) {
                            rects[i].y += pad;
                        }
                    }
                    break;
                }
                case BOTTOM:
                case TOP:
                default: {
                    int availableTabAreaWidth = size.width - insets.left - insets.right - tabAreaInsets.left - tabAreaInsets.right;
                    for (int run = 0; run < runCount; run++) {
                        int firstIndex = tabRuns[run];
                        int lastIndex = lastTabInRun(tabCount, run);
                        int usedTabAreaWidth = 0;
                        for (i = firstIndex; i <= lastIndex; i++) {
                            usedTabAreaWidth += rects[i].width;
                        }
                        int pad = (availableTabAreaWidth - usedTabAreaWidth) / 2;
                        for (i = firstIndex; i <= lastIndex; i++) {
                            rects[i].x += pad;
                        }
                    }

                    break;
                }
            }

        }

        private Insets add(Insets i1, Insets i2) {
            return new Insets(
                    i1.top + i2.top,
                    i1.left + i2.left,
                    i1.bottom + i2.bottom,
                    i1.right + i2.right
            );
        }

        private Insets add(int top, int left, int bottom, int right, Insets i1) {
            return new Insets(
                    i1.top + top,
                    i1.left + left,
                    i1.bottom + bottom,
                    i1.right + right
            );
        }

    }

}