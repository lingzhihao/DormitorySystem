package com.example.dormitorysystem.bean;

import java.util.List;

public class DormListModel {


    /**
     * hasNextPage : true
     * hasPrePage : false
     * isFirstPage : true
     * isLastPage : false
     * nextPage : 2
     * numbers : []
     * pageNo : 1
     * pageSize : 15
     * prePage : 1
     * rows : [{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－101","dormId":164,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－102","dormId":165,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－103","dormId":166,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－104","dormId":167,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－105","dormId":168,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－106","dormId":169,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－107","dormId":170,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－108","dormId":171,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－109","dormId":172,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－110","dormId":173,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－111","dormId":174,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－112","dormId":175,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－113","dormId":176,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－114","dormId":177,"nationName":""},{"areaId":1,"areaName":"中区","bedNum":6,"buildCode":"01A","buildId":1,"buildName":"笃志楼","campusId":1,"campusName":"黔南民族职业技术学院","categoryId":46,"categoryName":"","checkInNum":0,"dormCode":"01A－115","dormId":178,"nationName":""}]
     * total : 1944
     * totalPage : 130
     */

    private boolean hasNextPage;
    private boolean hasPrePage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int nextPage;
    private int pageNo;
    private int pageSize;
    private int prePage;
    private int total;
    private int totalPage;
    private List<?> numbers;
    private List<RowsBean> rows;

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<?> numbers) {
        this.numbers = numbers;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
         /**
         * areaId : 1
         * areaName : 中区
         * bedNum : 6
         * buildCode : 01A
         * buildId : 1
         * buildName : 笃志楼
         * campusId : 1
         * campusName : 黔南民族职业技术学院
         * categoryId : 46
         * categoryName :
         * checkInNum : 0
         * dormCode : 01A－101
         * dormId : 164
         * nationName :
         */

        private int areaId;
        private String areaName;
        private int bedNum;
        private String buildCode;
        private int buildId;
        private String buildName;
        private int campusId;
        private String campusName;
        private int categoryId;
        private String categoryName;
        private int checkInNum;
        private String dormCode;
        private int dormId;
        private String nationName;

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public int getBedNum() {
            return bedNum;
        }

        public void setBedNum(int bedNum) {
            this.bedNum = bedNum;
        }

        public String getBuildCode() {
            return buildCode;
        }

        public void setBuildCode(String buildCode) {
            this.buildCode = buildCode;
        }

        public int getBuildId() {
            return buildId;
        }

        public void setBuildId(int buildId) {
            this.buildId = buildId;
        }

        public String getBuildName() {
            return buildName;
        }

        public void setBuildName(String buildName) {
            this.buildName = buildName;
        }

        public int getCampusId() {
            return campusId;
        }

        public void setCampusId(int campusId) {
            this.campusId = campusId;
        }

        public String getCampusName() {
            return campusName;
        }

        public void setCampusName(String campusName) {
            this.campusName = campusName;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getCheckInNum() {
            return checkInNum;
        }

        public void setCheckInNum(int checkInNum) {
            this.checkInNum = checkInNum;
        }

        public String getDormCode() {
            return dormCode;
        }

        public void setDormCode(String dormCode) {
            this.dormCode = dormCode;
        }

        public int getDormId() {
            return dormId;
        }

        public void setDormId(int dormId) {
            this.dormId = dormId;
        }

        public String getNationName() {
            return nationName;
        }

        public void setNationName(String nationName) {
            this.nationName = nationName;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "areaId=" + areaId +
                    ", areaName='" + areaName + '\'' +
                    ", bedNum=" + bedNum +
                    ", buildCode='" + buildCode + '\'' +
                    ", buildId=" + buildId +
                    ", buildName='" + buildName + '\'' +
                    ", campusId=" + campusId +
                    ", campusName='" + campusName + '\'' +
                    ", categoryId=" + categoryId +
                    ", categoryName='" + categoryName + '\'' +
                    ", checkInNum=" + checkInNum +
                    ", dormCode='" + dormCode + '\'' +
                    ", dormId=" + dormId +
                    ", nationName='" + nationName + '\'' +
                    '}';
        }
    }
}
