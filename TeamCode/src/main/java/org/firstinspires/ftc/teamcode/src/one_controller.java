package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "golf24")
public class one_controller extends LinearOpMode {

    private DcMotor Front_right;
    private DcMotor Front_left;
    private DcMotor Back_left;
    private DcMotor Back_right;
    private DcMotor club;

    @Override
    public void runOpMode() throws InterruptedException {

        double Speed = 0.5;

        Front_right = hardwareMap.get(DcMotor.class, "FR");
        Front_left = hardwareMap.get(DcMotor.class, "FL");
        Back_left = hardwareMap.get(DcMotor.class, "BL");
        Back_right = hardwareMap.get(DcMotor.class, "BR");
        club = hardwareMap.get(DcMotor.class, "club");

        Front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        Front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        Back_left.setDirection(DcMotorSimple.Direction.FORWARD);
        Back_right.setDirection(DcMotorSimple.Direction.REVERSE);

        Front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        club.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {

            Back_left.setPower(Speed * (-gamepad1.right_stick_x + (+gamepad1.left_stick_y - -gamepad1.left_stick_x)));
            Back_right.setPower(Speed * (gamepad1.right_stick_x + +gamepad1.left_stick_y + -gamepad1.left_stick_x));
            Front_right.setPower(Speed * 1 * (gamepad1.right_stick_x + (+gamepad1.left_stick_y - -gamepad1.left_stick_x)));
            Front_left.setPower(Speed * 1 * (-gamepad1.right_stick_x + +gamepad1.left_stick_y + -gamepad1.left_stick_x));

            if (gamepad1.b) {
                Speed = 0.6;
            }

            if (gamepad1.y) {
                Speed = 1;
            }

            if (gamepad1.a) {
                Speed = 0.3;
            }

            if (gamepad1.right_trigger > gamepad1.left_trigger){
                club.setPower(gamepad1.right_trigger - gamepad1.left_trigger);
            } else if (gamepad1.left_trigger > gamepad1.right_trigger) {
                club.setPower(-(gamepad1.left_trigger - gamepad1.right_trigger));
            } else if (gamepad1.left_trigger < 0.05 && gamepad1.right_trigger < 0.05) {
                club.setPower(0);
            }
        }
    }
}
