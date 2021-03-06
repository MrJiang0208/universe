package com.jtw.main.mybatis.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 * User:  wanghongjie
 * Date:  2019/4/26 - 22:43
 * <p>
 * Description:
 */
public class EchoServer {
    /**
     * 服务端口号
     */
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup executors = new NioEventLoopGroup();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(executors, group).channel(NioServerSocketChannel.class).localAddress(port)
                    .childHandler(new ChannelInitializer<Channel>() {
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture f = serverBootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + "started and listen on “" + f.channel().localAddress());
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executors.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer(5210);
        try {
            echoServer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}