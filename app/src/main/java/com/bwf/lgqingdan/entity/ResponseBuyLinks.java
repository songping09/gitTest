package com.bwf.lgqingdan.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public class ResponseBuyLinks {

    /**
     * code : 0
     * message : Success
     * data : {"buylinks":[{"platform":{"name":"中国亚马逊","logoImageUrl":"http://img01.eqingdan.com/30012a64-8497-11e6-9911-00163e004c5e.jpeg?imageView2/1/w/48/h/48/q/75"},"price":"￥69","link":"https://www.amazon.cn/gp/product/B0177J71GM/ref=as_li_tf_tl?ie=UTF8&camp=536&creative=3200&creativeASIN=B0177J71GM&linkCode=as2&tag=eqingdan05-23","hasDescription":true,"description":"600ml"}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * platform : {"name":"中国亚马逊","logoImageUrl":"http://img01.eqingdan.com/30012a64-8497-11e6-9911-00163e004c5e.jpeg?imageView2/1/w/48/h/48/q/75"}
         * price : ￥69
         * link : https://www.amazon.cn/gp/product/B0177J71GM/ref=as_li_tf_tl?ie=UTF8&camp=536&creative=3200&creativeASIN=B0177J71GM&linkCode=as2&tag=eqingdan05-23
         * hasDescription : true
         * description : 600ml
         */

        private List<BuylinksBean> buylinks;

        public List<BuylinksBean> getBuylinks() {
            return buylinks;
        }

        public void setBuylinks(List<BuylinksBean> buylinks) {
            this.buylinks = buylinks;
        }

        public static class BuylinksBean {
            /**
             * name : 中国亚马逊
             * logoImageUrl : http://img01.eqingdan.com/30012a64-8497-11e6-9911-00163e004c5e.jpeg?imageView2/1/w/48/h/48/q/75
             */

            private PlatformBean platform;
            private String price;
            private String link;
            private boolean hasDescription;
            private String description;

            public PlatformBean getPlatform() {
                return platform;
            }

            public void setPlatform(PlatformBean platform) {
                this.platform = platform;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public boolean isHasDescription() {
                return hasDescription;
            }

            public void setHasDescription(boolean hasDescription) {
                this.hasDescription = hasDescription;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public static class PlatformBean {
                private String name;
                private String logoImageUrl;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLogoImageUrl() {
                    return logoImageUrl;
                }

                public void setLogoImageUrl(String logoImageUrl) {
                    this.logoImageUrl = logoImageUrl;
                }
            }
        }
    }
}
