package com.studycseathome.otptest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MobileVerification {
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;

    private void sendVerificationCode(String mobileNumber) {
        Log.d("message","sendVerificationCode");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+mobileNumber,60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallbacks);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
            mResendToken = forceResendingToken;
            Log.d("message","onCodeSent");
            Toast.makeText(MainActivity.this,"CodeSent", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            Log.d("message","onVerificationCompleted.");
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                otpField.setText(code);
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Log.d("message","sendVerificationFailed.");
            //Toast.makeText(get, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };
    private void verifyVerificationCode(String code) {
        //creating the credential
        Log.d("message","verifyVerificationCode");
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        Log.d("message","ignInWithPhoneAuthCredential");
        mAuth.signInWithCredential(credential).addOnCompleteListener(MainActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            /*Intent intent = new Intent(MainActivity.this, Activity2.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
*/
                        }
                        else {
                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
