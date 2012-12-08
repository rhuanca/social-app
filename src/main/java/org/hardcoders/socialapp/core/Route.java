package org.hardcoders.socialapp.core;

import java.util.ArrayList;
import java.util.List;

/**
 * User: milton.loayza@gmail.com
 * Date: 12/7/12 11:52 PM
 */
public class Route {
    List<Point> points = new ArrayList<Point>();

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
