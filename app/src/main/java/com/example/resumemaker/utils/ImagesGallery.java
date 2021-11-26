package com.example.resumemaker.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import androidx.loader.content.CursorLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;


//***************************************************
public class ImagesGallery
//***************************************************
{
    //***************************************************
    public static ArrayList<Uri> listOfImages(Context context)
    //***************************************************
    {
        Uri queryUri;
        Cursor cursor;
        int column_index_data;
        ArrayList<Uri> listOfAllImages = new ArrayList<Uri>();

        String absolutePathOfImage = null;
        queryUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

//
//        CursorLoader cursorLoader = new CursorLoader(
//                context,
//                queryUri,
//                projection,
//                null,
//                null, // Selection args (none).
//                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
//        );
//        cursor = cursorLoader.loadInBackground();
        cursor = context.getContentResolver().query(queryUri,
                projection,
                null,
                null,
                MediaStore.Files.FileColumns.DATE_ADDED + " DESC");
        while (cursor.moveToNext()) {
            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            absolutePathOfImage = cursor.getString(column_index_data);

            File file = new File(absolutePathOfImage);
            Uri uri = Uri.fromFile(file);

            File file1 = new File(uri.getPath());
            if (file1.length() != 0)
                listOfAllImages.add(uri);
            Log.i("ImageGallary : ",absolutePathOfImage);
        }

        return listOfAllImages;
    }

    //***************************************************
    public static ArrayList<Uri> listOfVideos(Context context)
    //***************************************************
    {
        Uri videoUri;
        Cursor videoCursor;
        int column_index_data_video;
        ArrayList<Uri> listOfAllVideos = new ArrayList<Uri>();

        String absolutePathOfImage = null;
        videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Video.Media.BUCKET_DISPLAY_NAME};

//
//        CursorLoader cursorLoader = new CursorLoader(
//                context,
//                videoUri,
//                projection,
//                null,
//                null, // Selection args (none).
//                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
//        );
//        videoCursor = cursorLoader.loadInBackground();


        videoCursor = context.getContentResolver().query(
                videoUri,
                projection,
                null,
                null, // Selection args (none).
                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
        );

        while (videoCursor.moveToNext()) {
            column_index_data_video = videoCursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            absolutePathOfImage = videoCursor.getString(column_index_data_video);

            File file = new File(absolutePathOfImage);
            Uri uri = Uri.fromFile(file);

            File file1 = new File(uri.getPath());
            if (file1.length() != 0)
                listOfAllVideos.add(Uri.parse(absolutePathOfImage));
        }

        return listOfAllVideos;
//        String orderBy = MediaStore.Video.Media.DATE_TAKEN;
//        videoCursor = context.getContentResolver().query(videoUri, projection, null,
//                null, orderBy + " DESC");
//        column_index_data_video = videoCursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
//        while (videoCursor.moveToNext()) {
//
//            absolutePathOfImage = videoCursor.getString(column_index_data_video);
//
//            listOfAllVideos.add(absolutePathOfImage);
//        }
//
//        return listOfAllVideos;
    }

    //***************************************************
    public static ArrayList<Uri> listOfMediaFiles(Context context)
    //***************************************************
    {
        Uri[] uri;
        Cursor cursor;
        int column_index_data;
        ArrayList<Uri> listOfAllMediaFiles = new ArrayList<Uri>();

        String absolutePathOfImage = null;

        uri = new Uri[]{MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI};


        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        String orderBy = MediaStore.Video.Media.DATE_TAKEN;

        for (int i = 0; i < uri.length; i++) {
            cursor = context.getContentResolver().query(uri[i], projection, null,
                    null, null);
//            MediaStore.Images.Media.DATE_ADDED + " ASC"
            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            while (cursor.moveToNext()) {

                absolutePathOfImage = cursor.getString(column_index_data);


                listOfAllMediaFiles.add(Uri.parse(absolutePathOfImage));
            }
        }


        return listOfAllMediaFiles;
    }

    //***************************************************
    public static ArrayList<Uri> getAllFiles(Context context)
    //***************************************************
    {
        Cursor cursor;
        int column_index_data;
        ArrayList<Uri> listOfAllMediaFiles = new ArrayList<Uri>();

        String absolutePathOfImage = null;

        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.DATA,
                MediaStore.Files.FileColumns.DATE_ADDED,
                MediaStore.Files.FileColumns.MEDIA_TYPE,
                MediaStore.Files.FileColumns.MIME_TYPE,
                MediaStore.Files.FileColumns.TITLE
        };
        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE
                + " OR "
                + MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;

        Uri queryUri = MediaStore.Files.getContentUri("external");

//        cursor = context.getContentResolver().query(queryUri, projection, selection,
//                null, MediaStore.Files.FileColumns.DATE_ADDED + " DESC");


//
//        CursorLoader cursorLoader = new CursorLoader(
//                context,
//                queryUri,
//                projection,
//                selection,
//                null, // Selection args (none).
//                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
//        );
//        cursor = cursorLoader.loadInBackground();



        cursor = context.getContentResolver().query(
                queryUri,
                projection,
                selection,
                null, // Selection args (none).
                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
        );

        while (cursor.moveToNext()) {
            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            absolutePathOfImage = cursor.getString(column_index_data);

            File file = new File(absolutePathOfImage);
            Uri uri = Uri.fromFile(file);


            File file1 = new File(uri.getPath());
            if (file1.length() != 0)
                listOfAllMediaFiles.add(uri);
            Log.i("ImageGallary : ",absolutePathOfImage);
        }

        return listOfAllMediaFiles;
    }
    //***************************************************
    public static ArrayList<Uri> getAllDoc(Context context)
    //***************************************************
    {
        Cursor cursor;
        int column_index_data;
        ArrayList<Uri> listOfAllMediaFiles = new ArrayList<Uri>();

        String absolutePathOfImage = null;

        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.DATA,
                MediaStore.Files.FileColumns.DATE_ADDED,
                MediaStore.Files.FileColumns.MEDIA_TYPE,
                MediaStore.Files.FileColumns.MIME_TYPE,
                MediaStore.Files.FileColumns.TITLE
        };
        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_DOCUMENT;

        Uri queryUri = MediaStore.Files.getContentUri("external");

//        cursor = context.getContentResolver().query(queryUri, projection, selection,
//                null, MediaStore.Files.FileColumns.DATE_ADDED + " DESC");


//        CursorLoader cursorLoader = new CursorLoader(
//                context,
//                queryUri,
//                projection,
//                selection,
//                null, // Selection args (none).
//                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
//        );
//        cursor = cursorLoader.loadInBackground();
//
        cursor = context.getContentResolver().query(
                queryUri,
                projection,
                selection,
                null, // Selection args (none).
                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
        );


        while (cursor.moveToNext()) {
            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            absolutePathOfImage = cursor.getString(column_index_data);

            File file = new File(absolutePathOfImage);
            Uri uri = Uri.fromFile(file);


            File file1 = new File(uri.getPath());
            if (file1.length() != 0){
                //System.out.println(absolutePathOfImage);

                String a=".PDF";


                    if(absolutePathOfImage.contains(a)||absolutePathOfImage.contains(a.toLowerCase()) ){
                        Log.i("ImageGallary : ",absolutePathOfImage);
                        listOfAllMediaFiles.add(uri);
                    }


            }




        }

        return listOfAllMediaFiles;
    }
    //***************************************************
    public static ArrayList<Uri> getAllAudio(Context context)
    //***************************************************
    {
        Cursor cursor;
        int column_index_data;
        ArrayList<Uri> listOfAllMediaFiles = new ArrayList<Uri>();

        String absolutePathOfImage = null;

        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.DATA,
                MediaStore.Files.FileColumns.DATE_ADDED,
                MediaStore.Files.FileColumns.MEDIA_TYPE,
                MediaStore.Files.FileColumns.MIME_TYPE,
                MediaStore.Files.FileColumns.TITLE
        };
        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_AUDIO;

        Uri queryUri = MediaStore.Files.getContentUri("external");

//        cursor = context.getContentResolver().query(queryUri, projection, selection,
//                null, MediaStore.Files.FileColumns.DATE_ADDED + " DESC");


//        CursorLoader cursorLoader = new CursorLoader(
//                context,
//                queryUri,
//                projection,
//                selection,
//                null, // Selection args (none).
//                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
//        );
//        cursor = cursorLoader.loadInBackground();

        cursor = context.getContentResolver().query(
                queryUri,
                projection,
                selection,
                null, // Selection args (none).
                MediaStore.Files.FileColumns.DATE_ADDED + " DESC" // Sort order.
        );


        while (cursor.moveToNext()) {
            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            absolutePathOfImage = cursor.getString(column_index_data);

            File file = new File(absolutePathOfImage);
            Uri uri = Uri.fromFile(file);


            File file1 = new File(uri.getPath());
            if (file1.length() != 0)
                listOfAllMediaFiles.add(uri);
            Log.i("ImageGallary : ",absolutePathOfImage);
        }

        return listOfAllMediaFiles;
    }
}
