package com.example.payslip;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DrawImage {

    private Canvas canvas;
    private Bitmap bmp;

    public DrawImage(){
        bmp = Bitmap.createBitmap(1000, 800, Bitmap.Config.ARGB_8888); //use ARGB_8888 for better quality
        bmp.eraseColor(Color.WHITE);
        canvas = new Canvas(bmp);
    }

    public DrawImage drawText(String text, int x, int y, int size){
        final Paint textPaint = new Paint( Paint.ANTI_ALIAS_FLAG) {
            {
                setColor(Color.BLACK);
                setTextAlign(Align.LEFT);
                setTextSize(size);
                setAntiAlias(true);
            }
        };
        final Rect bounds = new Rect();
//        textPaint.getTextBounds(text, 0, text.length(), bounds);
        textPaint.setStyle(Paint.Style.FILL);
        this.canvas.drawText(text,x,y,textPaint);
        return this;
    }

    String exportImage(String filePath) throws IOException {
//        String filePath = getApplicationInfo().dataDir +"/tmp.png";
        File tmpFile = new File(filePath);
        tmpFile.createNewFile();
        OutputStream out = new FileOutputStream(tmpFile, false);
        bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
        bmp.recycle();
        out.close();
        return filePath;
    }
}
