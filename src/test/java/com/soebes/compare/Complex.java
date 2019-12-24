package com.soebes.compare;

public class Complex {

  private double re;
  private double im;

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public double getRe() {
    return re;
  }

  public double getIm() {
    return im;
  }

  public Complex add(Complex complex) {
    return new Complex(this.re + complex.re, this.im + complex.im);
  }

  public Complex sub(Complex complex) {
    return new Complex(this.re - complex.re, this.im - complex.im);
  }
}
