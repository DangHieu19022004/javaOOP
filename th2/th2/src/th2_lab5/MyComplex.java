/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab5;
public class MyComplex {
    private double real;
    private double imag;

    // Constructor mặc định
    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Getter và Setter
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Phương thức kiểm tra số thực và số ảo
    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    // Phương thức equals
    public boolean equals(double real, double imag) {
        final double EPSILON = 1e-8;
        return Math.abs(this.real - real) < EPSILON && Math.abs(this.imag - imag) < EPSILON;
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.imag);
    }

    // Tính magnitude
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    // Tính argument
    public double argumentInRadians() {
        return Math.atan2(imag, real);
    }

    public double argumentInDegrees() {
        return Math.toDegrees(argumentInRadians());
    }

    // Tạo conjugate
    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

    // Phép toán cộng, trừ
    public MyComplex add(MyComplex another) {
        return new MyComplex(this.real + another.real, this.imag + another.imag);
    }

    public MyComplex subtract(MyComplex another) {
        return new MyComplex(this.real - another.real, this.imag - another.imag);
    }

    // Nhân và chia (sửa đổi đối tượng hiện tại)
    public MyComplex multiplyWith(MyComplex another) {
        double newReal = this.real * another.real - this.imag * another.imag;
        double newImag = this.real * another.imag + this.imag * another.real;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex divideBy(MyComplex another) {
        double denominator = another.real * another.real + another.imag * another.imag;
        double newReal = (this.real * another.real + this.imag * another.imag) / denominator;
        double newImag = (this.imag * another.real - this.real * another.imag) / denominator;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    // toString
    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }
}

