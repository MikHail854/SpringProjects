package com.apress.prospring5.ch3;

public class FtpArtworkSender implements ArtworkSender{

    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        //здесь следует логика обмена данными по сетевому протколу FTP...
    }

    @Override
    public String getFriendlyName() {
        return "File Transfer Protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
