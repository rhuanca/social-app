package org.hardcoders.socialapp.core;

/**
 * User: milton.loayza@gmail.com
 * Date: 12/7/12 11:49 PM
 */
public class Point {
    double x,y,ratio;
    public Point(){}
    public Point(double xx,double yy){x = xx;y = yy;}
    double mod(){return Math.sqrt(x*x+y*y);}
    Point orto(){return new Point(-y,x);}
    Point unit(){double k = mod();return new Point(x/k,y/k);}
    void p(){System.out.println("::> "+x+" "+y);}

    Point operatorPlus(Point A, Point B){return new Point(A.x+B.x,A.y+B.y);}
    Point operatorMinus(Point A,Point B){return new Point(A.x-B.x,A.y-B.y);}
    Point operatorMultiply(Point A, Point B){return new Point(A.x*B.x,A.y*B.y);}
    Point operatorDivide(Point A,double k){return new Point(A.x/k,A.y/k);}
    Point operatorMultiply(Point A,double k){return new Point(A.x*k,A.y*k);}
    //boolean operatorLessThan (Point A, Point B){return pair<PP,PP>(A.x,A.y) < pair<PP,PP>(B.x,B.y);}
    double EPS = 0.0;
    double PI  = Math.acos(-1);
    double oo = 1e18;

    double cross(Point A,Point B){return A.x*B.y - A.y*B.x;}
    double dot(Point A,Point B){return A.x*B.x + A.y*B.y;}
    double dist(Point A,Point B){return Math.sqrt(A.x * B.x + A.y * B.y);}
    double area2(Point A,Point B,Point C){return cross(operatorMinus(B,A),operatorMinus(C, A));}//For the triangle A,B,C  using A->B, A->C

    boolean pointInBox(Point P,Point A,Point B){//Point P inside box A,B
        return P.x >= Math.min(A.x,B.x) && P.x <= Math.max(A.x, B.x) &&
        P.y >= Math.min(A.y, B.y) && P.y <= Math.max(A.y,B.y);
    }

    double distToSegment(Point A,Point B,Point P){//dist from P to AB
        Point D = operatorPlus(P,operatorMinus(B,A).orto());//perpendicular to AB
        Point p_int = operatorPlus(A ,operatorMultiply((operatorMinus(B,A)),(cross(operatorMinus(P,A), operatorMinus(D,P))/cross(operatorMinus(B,A), operatorMinus(D,P)))));
        if(pointInBox(p_int,A,B))
            return dist(P,p_int);
        else{//The answer is some Point
            double da = dist(A,P);
            double db = dist(B,P);
            p_int = da < db?A:B;
            return Math.min(da, db);
        }
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
