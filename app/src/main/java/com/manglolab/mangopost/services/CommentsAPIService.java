package com.manglolab.mangopost.services;

import com.manglolab.mangopost.model.pojo.Comment;
import com.manglolab.mangopost.model.pojo.Post;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by rajforhad on 11/10/2016.
 */

public class CommentsAPIService {

    private interface CommentService {
        @GET("/comments")
        Observable<List<Comment>> getCommentsList();
    }

    private Observable<List<Comment>> commentsObservable = new RestAdapter.Builder()
            .setEndpoint("http://jsonplaceholder.typicode.com")
            .build().create(CommentsAPIService.CommentService.class).getCommentsList().cache();


    public Observable<List<Comment>> getCommentsObservable() {
        return commentsObservable;
    }
}
