package com.example.jozvefaal30;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jozvefaal30.model.SharedPreferencesManager;
import com.example.jozvefaal30.model.userApp;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    userApp user = new userApp();

    /*create object for xml*/
    Button btnSingUp;
    EditText edtUName, edtPasword,edtrepassword,name,family,edtEmail, edtPhone,reshte;
    ImageView imageView;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;
    String encodedImageData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //for full screen page
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        /* Get object from xml file*/
        btnSingUp = findViewById(R.id.btn_ok_signup);
        edtUName = findViewById(R.id.signup_user_name);
        edtPasword = findViewById(R.id.signup_password);
        edtrepassword= findViewById(R.id.signup_repassword);
        name = findViewById(R.id.signup_name);
        family = findViewById(R.id.signup_family);
        reshte = findViewById(R.id.signup_reshte);
        edtEmail = findViewById(R.id.signup_email);
        edtPhone = findViewById(R.id.signup_phone_number);
        imageView = findViewById(R.id.img_user);
        /*1.calling method for get Permissions*/
        requestMultiplePermissions();
        /*3.click buttton to singup and save vlue user write*/
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*2.set true first time to SharedPreferences*/
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getApplicationContext());
                user = sharedPreferencesManager.get_shared_preferences();
                user.setFirst_time_run(true);
                sharedPreferencesManager.set_false_first_time(user);

                /*4.get value user write to edit text*/
                String userName = edtUName.getText().toString();
                String password = edtPasword.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();
                String repassword = edtPhone.getText().toString();
                String reshte = edtPhone.getText().toString();
                String name = edtPhone.getText().toString();
                String family = edtPhone.getText().toString();



                /*5.check edit text is empty or no*/
                if (!userName.equals("") && !password.equals("") && isEmailValid(email)==true && !phone.equals("") &&
                        !repassword.equals("")&& !reshte.equals("")&& !name.equals("")&& !family.equals("")) {
                    //for image=======
                    try {
                        imageView.buildDrawingCache();
                        Bitmap bmap = imageView.getDrawingCache();
                        encodedImageData = getEncoded64ImageStringFromBitmap(bmap);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    /*6.Save UserName with SharedPreferences*/
                    SharedPreferences userDetails = getApplicationContext().getSharedPreferences("User", MODE_PRIVATE);
                    SharedPreferences.Editor edit = userDetails.edit();
                    edit.putString(userName, userName);
                    edit.putString(password, password);
                    edit.apply();

                    SharedPreferences userDetails2 = getApplicationContext().getSharedPreferences("TITLE", MODE_PRIVATE);
                    SharedPreferences.Editor edit2 = userDetails2.edit();
                    edit2.putString("title", userName);
                    edit2.apply();

                    /*7.open main activity*/
                    startActivity(new Intent(signup.this, MainActivity.class));
                    signup.this.finish();

                    /*8.set false More than once to SharedPreferences*/
                    user.setFirst_time_run(false);
                    sharedPreferencesManager.set_false_first_time(user);
                }
                else {
                    if (!isEmailValid(email)==true) {
                        Toast.makeText(getApplicationContext(), "الگوی ایمیل اشتباه است! ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(signup.this, "لطفا اطلاعات را کامل کنید!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureDialog();
            }
        });
    }
    /*method to return email is valid or no*/
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /*10.do and checked your image selected and show to imageView is successful */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    Bitmap bMapScaled = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
                    String path = saveImage(bMapScaled);
                    Toast.makeText(this, "عکس بدرستی انتخاب شد", Toast.LENGTH_SHORT).show();
                    imageView.setImageBitmap(bMapScaled);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "خطایی رخ داد!", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            Bitmap bMapScaled = Bitmap.createScaledBitmap(thumbnail, 100, 100, true);
            imageView.setImageBitmap(bMapScaled);
            saveImage(bMapScaled);
            Toast.makeText(this, "عکس به درستی انتخاب شد", Toast.LENGTH_SHORT).show();
        }
    }

    /*11.return images url you selected */
    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }
        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    /*12.method to show AlertDialog*/
    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("انتخاب عملیات");
        String[] pictureDialogItems = {
                "انتخاب عکس از گالری",
                "گرفتن عکس با دوربین"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    /*13.methode to show your gallery*/
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY);
    }

    /*14.methode to show your camera*/
    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    /*15.method to get Permissions from your phone*/
    private void requestMultiplePermissions() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "مجوزهای لازم از کاربر دریافت شده", Toast.LENGTH_SHORT).show();
                        }
                        if (report.isAnyPermissionPermanentlyDenied()) {
                        }
                    }
                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "خطایی رخ داد! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    /*16.method  convert bitmap to string*/
    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);
        return imgString;
    }


}

