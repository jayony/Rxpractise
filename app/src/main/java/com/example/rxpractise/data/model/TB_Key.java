package com.example.rxpractise.data.model;

import android.net.Uri;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.provider.BaseSyncableProviderModel;

@Table(database = DB_BookKeyDatabase.class,allFields = true)
public class TB_Key extends BaseSyncableProviderModel {

    public static final String AUTHORITY = "com.rxPrictise.android.db.provider";
    public static final String BASE_CONTENT_URI = "content://";

    @PrimaryKey(autoincrement = true)
    long _id;

    public String origin_file;
    public String created_at;
    public int book_id;
    public int version;
    public String mac;
    public String uid;
    public String file;
    public String updated_at;
    public int user_id;
    public String expire;
    public int id;
    public String key;
    public String md5;

    public Uri buildUri(String... paths) {
        Uri.Builder builder = Uri.parse(BASE_CONTENT_URI + AUTHORITY).buildUpon();
        for (String path : paths) {
            builder.appendPath(path);
        }
        return builder.build();
    }


    @Override
    public Uri getDeleteUri() {
        return buildUri();
    }

    @Override
    public Uri getInsertUri() {
        return buildUri();
    }

    @Override
    public Uri getUpdateUri() {
        return buildUri();
    }

    @Override
    public Uri getQueryUri() {
        return buildUri();
    }
}
