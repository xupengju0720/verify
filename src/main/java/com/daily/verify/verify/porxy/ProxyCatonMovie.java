package com.daily.verify.verify.porxy;

public class ProxyCatonMovie implements Movie {
    Movie movie;


    public ProxyCatonMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void show() {
        showBefore();
        movie.show();
        showAfter();
    }

    private void showAfter() {
        System.out.println("卡通电影播放完成");
    }

    private void showBefore() {
        System.out.println("卡通电影播放前准备");
    }
}
