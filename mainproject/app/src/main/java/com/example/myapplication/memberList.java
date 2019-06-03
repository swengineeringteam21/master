package com.example.myapplication;

public class memberList {
    private int memberImage;
    private String memberName;
    private String memberIntroduce;
    private String memberRank;

    public memberList(int memberImage, String memberName, String memberIntroduce, String memberRank) {
        this.memberImage = memberImage;
        this.memberName = memberName;
        this.memberIntroduce = memberIntroduce;
        this.memberRank = memberRank;
    }

    public int getMemberImage() {
        return memberImage;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberIntroduce() {
        return memberIntroduce;
    }

    public String getMemberRank() {
        return memberRank;
    }
}
