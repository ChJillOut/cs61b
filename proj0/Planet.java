public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  public Planet(double xP, double yP, double xV,double yV, double m, String img) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {
    double dx = p.xxPos-this.xxPos;
    double dy = p.yyPos-this.yyPos;
    double r = Math.sqrt((dx * dx) + (dy * dy));
    return r;
  }

  public double calcForceExertedBy(Planet p) {
    double G = 6.67e-11;
    double F = (G * p.mass * this.mass)/(this.calcDistance(p) * this.calcDistance(p));
    return F;
  }

  public double calcForceExertedByX(Planet p) {
    double Fx = (calcForceExertedBy(p) * (p.xxPos-this.xxPos))/calcDistance(p);
    return Fx;
  }

  public double calcForceExertedByY(Planet p) {
    double Fy = (calcForceExertedBy(p) * (p.yyPos-this.yyPos))/calcDistance(p);
    return Fy;
  }

  public double calcNetForceExertedByX(Planet[] allPlanets) {
    double Fxnet = 0;
    for (Planet p: allPlanets) {
      if (p.equals(this)) {
        continue;
      }
      else {
        Fxnet = Fxnet + calcForceExertedByX(p);
      }
    }
    return Fxnet;
  }

  public double calcNetForceExertedByY(Planet[] allPlanets) {
    double Fynet = 0;
    for (Planet p: allPlanets) {
      if (p.equals(this)) {
        continue;
      }
      else {
        Fynet = Fynet + calcForceExertedByY(p);
      }
    }
    return Fynet;
  }

  public void update(double dt, double fX, double fY) {
    double a_net_x = fX/this.mass;
    double a_net_y = fY/this.mass;
    this.xxVel = this.xxVel + dt * a_net_x;
    this.yyVel = this.yyVel + dt * a_net_y;
    this.xxPos = this.xxPos + dt * this.xxVel;
    this.yyPos = this.yyPos + dt * this.yyVel;
  }

  public void draw() {
    String filename = "./images/" + this.imgFileName;
    StdDraw.picture(this.xxPos, this.yyPos, filename);
  }


}
