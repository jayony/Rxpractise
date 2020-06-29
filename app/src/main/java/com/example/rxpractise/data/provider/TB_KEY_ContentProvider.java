package com.example.rxpractise.data.provider;

import android.net.Uri;

import com.example.rxpractise.data.model.DB_BookKeyDatabase;
import com.raizlabs.android.dbflow.annotation.provider.ContentProvider;
import com.raizlabs.android.dbflow.annotation.provider.ContentUri;
import com.raizlabs.android.dbflow.annotation.provider.TableEndpoint;


class TB_KEY_ContentProvider {

    public static final String AUTHORITY = "com.rxPrictise.android.db.provider";

    public static final String BASE_CONTENT_URI = "content://";


    @TableEndpoint(name = ContentProviderModel.ENDPOINT,contentProvider = TB_KEY_ContentProvider.class)
    public static class ContentProviderModel {

        public static final String ENDPOINT = "ContentProviderModel";

        private static Uri buildUri(String... paths) {
            Uri.Builder builder = Uri.parse(BASE_CONTENT_URI + AUTHORITY).buildUpon();
            for (String path : paths) {
                builder.appendPath(path);
            }
            return builder.build();
        }

        @ContentUri(path = ContentProviderModel.ENDPOINT,
                type = ContentUri.ContentType.VND_MULTIPLE + ENDPOINT)
        public static Uri CONTENT_URI = buildUri(ENDPOINT);

    }

}