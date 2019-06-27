package com.example.dormitorysystem.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OkGoTest {


    /**
     * status : 1
     * data : {"province":"江苏省","cross_list":[{"distance":"149.103","direction":"West","name":"联谊路--绿溪路","weight":"120","level":"45000, 45000","longitude":"121.0508253","crossid":"021H51F0090093035--021H51F009009851","width":"8, 12","latitude":"31.31557944"},{"distance":"257.444","direction":"East","name":"陆家浜北路--教堂路","weight":"120","level":"45000, 45000","longitude":"121.0465464","crossid":"021H51F0090094608--021H51F009009612276","width":"8, 8","latitude":"31.31554639"},{"distance":"272.069","direction":"NorthEast","name":"陆家浜南路--绿溪路","weight":"120","level":"45000, 45000","longitude":"121.0482211","crossid":"021H51F0090093125--021H51F009009851","width":"8, 12","latitude":"31.31330917"}],"code":"1","tel":"0512","cityadcode":"320500","areacode":"0512","timestamp":"1561356393.38","sea_area":{"adcode":"","name":""},"pos":"在陆家镇人民政府附近, 在绿溪路旁边, 靠近联谊路--绿溪路路口","road_list":[{"distance":"77","direction":"NorthWest","name":"绿溪路","level":"5","longitude":"121.05","width":"12","roadid":"021H51F009009851","latitude":"31.3151"},{"distance":"141","direction":"SouthEast","name":"教堂路","level":"5","longitude":"121.048","width":"8","roadid":"021H51F009009612276","latitude":"31.3163"},{"distance":"191","direction":"West","name":"联谊路","level":"5","longitude":"121.051","width":"8","roadid":"021H51F0090093035","latitude":"31.3158"}],"hn":"20号","result":"true","message":"Successful.","desc":"江苏省,苏州市,昆山市","city":"苏州市","districtadcode":"320583","district":"昆山市","countrycode":"CN","country":"中国","provinceadcode":"320000","version":"2.0-3.0.9171.1726","adcode":"320583","poi_list":[{"parent":"","distance":"149","direction":"West","tel":"0512-57877735;0512-57671209","name":"昆山市第四人民医院","weight":"0.0","typecode":"090100","childtype":"","longitude":"121.047687","towards_angle":"","f_nona":"","address":"陆家浜北路21号","latitude":"31.315573","entrances":[{"latitude":"31.314923","longitude":"121.047078"}],"end_poi_extension":"2","type":"医疗保健服务;综合医院;综合医院","poiid":"B020007Y9K"},{"parent":"","distance":"159","direction":"West","tel":"0512-57671209;0512-57879719","name":"昆山市陆家人民医院","weight":"0.0","typecode":"090100","childtype":"","longitude":"121.047582","towards_angle":"","f_nona":"","address":"陆家镇镇北路21号","latitude":"31.315498","entrances":[{"latitude":"31.314934","longitude":"121.047102"}],"end_poi_extension":"2","type":"医疗保健服务;综合医院;综合医院","poiid":"B020016BMR"},{"parent":"","distance":"138","direction":"SouthWest","tel":"0512-57671003","name":"陆家镇人民政府","weight":"0.0","typecode":"130105","childtype":"","longitude":"121.048460","towards_angle":"153.10","f_nona":"","address":"菉溪路22号","latitude":"31.314546","entrances":[{"latitude":"31.314413","longitude":"121.048453"}],"end_poi_extension":"2","type":"政府机构及社会团体;政府机关;乡镇级政府及事业单位","poiid":"B020007YBU"},{"parent":"","distance":"139","direction":"SouthWest","tel":"","name":"陆家镇人民代表大会","weight":"0.0","typecode":"130105","childtype":"","longitude":"121.048458","towards_angle":"153.20","f_nona":"","address":"菉溪路22号","latitude":"31.314539","end_poi_extension":"2","type":"政府机构及社会团体;政府机关;乡镇级政府及事业单位","poiid":"B020007YBT"},{"parent":"","distance":"139","direction":"SouthWest","tel":"","name":"中共昆山市陆家镇委员会","weight":"0.0","typecode":"130105","childtype":"","longitude":"121.048458","towards_angle":"153.20","f_nona":"","address":"菉溪路22号","latitude":"31.314539","end_poi_extension":"2","type":"政府机构及社会团体;政府机关;乡镇级政府及事业单位","poiid":"B020008HW1"}]}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * province : 江苏省
         * cross_list : [{"distance":"149.103","direction":"West","name":"联谊路--绿溪路","weight":"120","level":"45000, 45000","longitude":"121.0508253","crossid":"021H51F0090093035--021H51F009009851","width":"8, 12","latitude":"31.31557944"},{"distance":"257.444","direction":"East","name":"陆家浜北路--教堂路","weight":"120","level":"45000, 45000","longitude":"121.0465464","crossid":"021H51F0090094608--021H51F009009612276","width":"8, 8","latitude":"31.31554639"},{"distance":"272.069","direction":"NorthEast","name":"陆家浜南路--绿溪路","weight":"120","level":"45000, 45000","longitude":"121.0482211","crossid":"021H51F0090093125--021H51F009009851","width":"8, 12","latitude":"31.31330917"}]
         * code : 1
         * tel : 0512
         * cityadcode : 320500
         * areacode : 0512
         * timestamp : 1561356393.38
         * sea_area : {"adcode":"","name":""}
         * pos : 在陆家镇人民政府附近, 在绿溪路旁边, 靠近联谊路--绿溪路路口
         * road_list : [{"distance":"77","direction":"NorthWest","name":"绿溪路","level":"5","longitude":"121.05","width":"12","roadid":"021H51F009009851","latitude":"31.3151"},{"distance":"141","direction":"SouthEast","name":"教堂路","level":"5","longitude":"121.048","width":"8","roadid":"021H51F009009612276","latitude":"31.3163"},{"distance":"191","direction":"West","name":"联谊路","level":"5","longitude":"121.051","width":"8","roadid":"021H51F0090093035","latitude":"31.3158"}]
         * hn : 20号
         * result : true
         * message : Successful.
         * desc : 江苏省,苏州市,昆山市
         * city : 苏州市
         * districtadcode : 320583
         * district : 昆山市
         * countrycode : CN
         * country : 中国
         * provinceadcode : 320000
         * version : 2.0-3.0.9171.1726
         * adcode : 320583
         * poi_list : [{"parent":"","distance":"149","direction":"West","tel":"0512-57877735;0512-57671209","name":"昆山市第四人民医院","weight":"0.0","typecode":"090100","childtype":"","longitude":"121.047687","towards_angle":"","f_nona":"","address":"陆家浜北路21号","latitude":"31.315573","entrances":[{"latitude":"31.314923","longitude":"121.047078"}],"end_poi_extension":"2","type":"医疗保健服务;综合医院;综合医院","poiid":"B020007Y9K"},{"parent":"","distance":"159","direction":"West","tel":"0512-57671209;0512-57879719","name":"昆山市陆家人民医院","weight":"0.0","typecode":"090100","childtype":"","longitude":"121.047582","towards_angle":"","f_nona":"","address":"陆家镇镇北路21号","latitude":"31.315498","entrances":[{"latitude":"31.314934","longitude":"121.047102"}],"end_poi_extension":"2","type":"医疗保健服务;综合医院;综合医院","poiid":"B020016BMR"},{"parent":"","distance":"138","direction":"SouthWest","tel":"0512-57671003","name":"陆家镇人民政府","weight":"0.0","typecode":"130105","childtype":"","longitude":"121.048460","towards_angle":"153.10","f_nona":"","address":"菉溪路22号","latitude":"31.314546","entrances":[{"latitude":"31.314413","longitude":"121.048453"}],"end_poi_extension":"2","type":"政府机构及社会团体;政府机关;乡镇级政府及事业单位","poiid":"B020007YBU"},{"parent":"","distance":"139","direction":"SouthWest","tel":"","name":"陆家镇人民代表大会","weight":"0.0","typecode":"130105","childtype":"","longitude":"121.048458","towards_angle":"153.20","f_nona":"","address":"菉溪路22号","latitude":"31.314539","end_poi_extension":"2","type":"政府机构及社会团体;政府机关;乡镇级政府及事业单位","poiid":"B020007YBT"},{"parent":"","distance":"139","direction":"SouthWest","tel":"","name":"中共昆山市陆家镇委员会","weight":"0.0","typecode":"130105","childtype":"","longitude":"121.048458","towards_angle":"153.20","f_nona":"","address":"菉溪路22号","latitude":"31.314539","end_poi_extension":"2","type":"政府机构及社会团体;政府机关;乡镇级政府及事业单位","poiid":"B020008HW1"}]
         */

        private String province;
        @SerializedName("code")
        private String code;
        private String tel;
        private String cityadcode;
        private String areacode;
        private String timestamp;
        private SeaAreaBean sea_area;
        private String pos;
        private String hn;
        private String result;
        private String message;
        private String desc;
        private String city;
        private String districtadcode;
        private String district;
        private String countrycode;
        private String country;
        private String provinceadcode;
        private String version;
        private String adcode;
        private List<CrossListBean> cross_list;
        private List<RoadListBean> road_list;
        private List<PoiListBean> poi_list;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCityadcode() {
            return cityadcode;
        }

        public void setCityadcode(String cityadcode) {
            this.cityadcode = cityadcode;
        }

        public String getAreacode() {
            return areacode;
        }

        public void setAreacode(String areacode) {
            this.areacode = areacode;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public SeaAreaBean getSea_area() {
            return sea_area;
        }

        public void setSea_area(SeaAreaBean sea_area) {
            this.sea_area = sea_area;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public String getHn() {
            return hn;
        }

        public void setHn(String hn) {
            this.hn = hn;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrictadcode() {
            return districtadcode;
        }

        public void setDistrictadcode(String districtadcode) {
            this.districtadcode = districtadcode;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getCountrycode() {
            return countrycode;
        }

        public void setCountrycode(String countrycode) {
            this.countrycode = countrycode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvinceadcode() {
            return provinceadcode;
        }

        public void setProvinceadcode(String provinceadcode) {
            this.provinceadcode = provinceadcode;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public List<CrossListBean> getCross_list() {
            return cross_list;
        }

        public void setCross_list(List<CrossListBean> cross_list) {
            this.cross_list = cross_list;
        }

        public List<RoadListBean> getRoad_list() {
            return road_list;
        }

        public void setRoad_list(List<RoadListBean> road_list) {
            this.road_list = road_list;
        }

        public List<PoiListBean> getPoi_list() {
            return poi_list;
        }

        public void setPoi_list(List<PoiListBean> poi_list) {
            this.poi_list = poi_list;
        }

        public static class SeaAreaBean {
            /**
             * adcode :
             * name :
             */

            private String adcode;
            private String name;

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class CrossListBean {
            /**
             * distance : 149.103
             * direction : West
             * name : 联谊路--绿溪路
             * weight : 120
             * level : 45000, 45000
             * longitude : 121.0508253
             * crossid : 021H51F0090093035--021H51F009009851
             * width : 8, 12
             * latitude : 31.31557944
             */

            private String distance;
            private String direction;
            private String name;
            private String weight;
            private String level;
            private String longitude;
            private String crossid;
            private String width;
            private String latitude;

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getCrossid() {
                return crossid;
            }

            public void setCrossid(String crossid) {
                this.crossid = crossid;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }
        }

        public static class RoadListBean {
            /**
             * distance : 77
             * direction : NorthWest
             * name : 绿溪路
             * level : 5
             * longitude : 121.05
             * width : 12
             * roadid : 021H51F009009851
             * latitude : 31.3151
             */

            private String distance;
            private String direction;
            private String name;
            private String level;
            private String longitude;
            private String width;
            private String roadid;
            private String latitude;

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getRoadid() {
                return roadid;
            }

            public void setRoadid(String roadid) {
                this.roadid = roadid;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }
        }

        public static class PoiListBean {
            /**
             * parent :
             * distance : 149
             * direction : West
             * tel : 0512-57877735;0512-57671209
             * name : 昆山市第四人民医院
             * weight : 0.0
             * typecode : 090100
             * childtype :
             * longitude : 121.047687
             * towards_angle :
             * f_nona :
             * address : 陆家浜北路21号
             * latitude : 31.315573
             * entrances : [{"latitude":"31.314923","longitude":"121.047078"}]
             * end_poi_extension : 2
             * type : 医疗保健服务;综合医院;综合医院
             * poiid : B020007Y9K
             */

            private String parent;
            private String distance;
            private String direction;
            private String tel;
            private String name;
            private String weight;
            private String typecode;
            private String childtype;
            private String longitude;
            private String towards_angle;
            private String f_nona;
            private String address;
            private String latitude;
            private String end_poi_extension;
            private String type;
            private String poiid;
            private List<EntrancesBean> entrances;

            public String getParent() {
                return parent;
            }

            public void setParent(String parent) {
                this.parent = parent;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getTypecode() {
                return typecode;
            }

            public void setTypecode(String typecode) {
                this.typecode = typecode;
            }

            public String getChildtype() {
                return childtype;
            }

            public void setChildtype(String childtype) {
                this.childtype = childtype;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getTowards_angle() {
                return towards_angle;
            }

            public void setTowards_angle(String towards_angle) {
                this.towards_angle = towards_angle;
            }

            public String getF_nona() {
                return f_nona;
            }

            public void setF_nona(String f_nona) {
                this.f_nona = f_nona;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getEnd_poi_extension() {
                return end_poi_extension;
            }

            public void setEnd_poi_extension(String end_poi_extension) {
                this.end_poi_extension = end_poi_extension;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPoiid() {
                return poiid;
            }

            public void setPoiid(String poiid) {
                this.poiid = poiid;
            }

            public List<EntrancesBean> getEntrances() {
                return entrances;
            }

            public void setEntrances(List<EntrancesBean> entrances) {
                this.entrances = entrances;
            }

            public static class EntrancesBean {
                /**
                 * latitude : 31.314923
                 * longitude : 121.047078
                 */

                private String latitude;
                private String longitude;

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }
        }
    }
}
