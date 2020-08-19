package com.daily.verify.verify.porxy;

/**
 * 面向接口的代理模式 示例
 */
public class test {
    public static void main(String[] args) {
        Movie movie = new CatonMovie();
        Movie proxyMovie = new ProxyCatonMovie(movie);
        proxyMovie.show();
    }
}
