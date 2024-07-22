package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class one_controller extends LinearOpMode {

    DcMotorSimple FL = hardwareMap.dcMotor.get("FL");
    DcMotorSimple FR = hardwareMap.dcMotor.get("FR");
    DcMotorSimple BL = hardwareMap.dcMotor.get("BL");
    DcMotorSimple BR = hardwareMap.dcMotor.get("BR");
    DcMotorSimple club = hardwareMap.dcMotor.get("club");

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            FL.setPower(frontLeftPower);
            FR.setPower(-backLeftPower);
            BL.setPower(frontRightPower);
            BR.setPower(-backRightPower);

        }
    }
}
