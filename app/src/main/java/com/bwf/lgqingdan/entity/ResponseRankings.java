package com.bwf.lgqingdan.entity;

import java.util.List;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class ResponseRankings {

    /**
     * code : 0
     * message : Success
     * data : {"rankings":[{"id":33,"title":"乳液","slug":"lotion","featuredImageUrl":"http://img01.eqingdan.com/a5767c94-91c2-11e6-92a3-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/a9108836-91c2-11e6-ae5a-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-14 18:57:51","publishedAtDiffForHumans":"4天前","thingCount":34,"reviewCount":94,"links":{"self":"http://api.eqingdan.com/v1/rankings/33","share":"http://www.eqingdan.com/mobile/rankings/lotion"}},{"id":32,"title":"防晒霜","slug":"sunscreen","featuredImageUrl":"http://img01.eqingdan.com/aeae9472-905a-11e6-b46a-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/b12e55ca-905a-11e6-a196-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-12 17:11:04","publishedAtDiffForHumans":"6天前","thingCount":45,"reviewCount":310,"links":{"self":"http://api.eqingdan.com/v1/rankings/32","share":"http://www.eqingdan.com/mobile/rankings/sunscreen"}},{"id":31,"title":"护发精油","slug":"hair_treatment","featuredImageUrl":"http://img01.eqingdan.com/e20becca-8eac-11e6-82db-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/e3d228a8-8eac-11e6-a3a8-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-11 21:59:59","publishedAtDiffForHumans":"1周前","thingCount":27,"reviewCount":112,"links":{"self":"http://api.eqingdan.com/v1/rankings/31","share":"http://www.eqingdan.com/mobile/rankings/hair_treatment"}},{"id":30,"title":"护发素","slug":"hair_conditioner","featuredImageUrl":"http://img01.eqingdan.com/7b97586e-8e00-11e6-9ad3-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/7cef09c8-8e00-11e6-bf37-00163e002745.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-09 18:26:30","publishedAtDiffForHumans":"1周前","thingCount":54,"reviewCount":391,"links":{"self":"http://api.eqingdan.com/v1/rankings/30","share":"http://www.eqingdan.com/mobile/rankings/hair_conditioner"}},{"id":28,"title":"眼霜","slug":"eye_cream","featuredImageUrl":"http://img01.eqingdan.com/c41d8d14-8bcc-11e6-8d90-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","thumbnailImageUrl":"http://img01.eqingdan.com/c73f1440-8bcc-11e6-bd87-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75","body":"","publishedAt":"2016-10-07 16:00:00","publishedAtDiffForHumans":"1周前","thingCount":56,"reviewCount":646,"links":{"self":"http://api.eqingdan.com/v1/rankings/28","share":"http://www.eqingdan.com/mobile/rankings/eye_cream"}}]}
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
         * id : 33
         * title : 乳液
         * slug : lotion
         * featuredImageUrl : http://img01.eqingdan.com/a5767c94-91c2-11e6-92a3-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75
         * thumbnailImageUrl : http://img01.eqingdan.com/a9108836-91c2-11e6-ae5a-00163e004c5e.jpeg?imageView2/1/w/200/h/150/q/75
         * body :
         * publishedAt : 2016-10-14 18:57:51
         * publishedAtDiffForHumans : 4天前
         * thingCount : 34
         * reviewCount : 94
         * links : {"self":"http://api.eqingdan.com/v1/rankings/33","share":"http://www.eqingdan.com/mobile/rankings/lotion"}
         */

        private List<RankingsBean> rankings;

        public List<RankingsBean> getRankings() {
            return rankings;
        }

        public void setRankings(List<RankingsBean> rankings) {
            this.rankings = rankings;
        }

        public static class RankingsBean {
            private int id;
            private String title;
            private String slug;
            private String featuredImageUrl;
            private String thumbnailImageUrl;
            private String body;
            private String publishedAt;
            private String publishedAtDiffForHumans;
            private int thingCount;
            private int reviewCount;
            /**
             * self : http://api.eqingdan.com/v1/rankings/33
             * share : http://www.eqingdan.com/mobile/rankings/lotion
             */

            private LinksBean links;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getFeaturedImageUrl() {
                return featuredImageUrl;
            }

            public void setFeaturedImageUrl(String featuredImageUrl) {
                this.featuredImageUrl = featuredImageUrl;
            }

            public String getThumbnailImageUrl() {
                return thumbnailImageUrl;
            }

            public void setThumbnailImageUrl(String thumbnailImageUrl) {
                this.thumbnailImageUrl = thumbnailImageUrl;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getPublishedAtDiffForHumans() {
                return publishedAtDiffForHumans;
            }

            public void setPublishedAtDiffForHumans(String publishedAtDiffForHumans) {
                this.publishedAtDiffForHumans = publishedAtDiffForHumans;
            }

            public int getThingCount() {
                return thingCount;
            }

            public void setThingCount(int thingCount) {
                this.thingCount = thingCount;
            }

            public int getReviewCount() {
                return reviewCount;
            }

            public void setReviewCount(int reviewCount) {
                this.reviewCount = reviewCount;
            }

            public LinksBean getLinks() {
                return links;
            }

            public void setLinks(LinksBean links) {
                this.links = links;
            }

            public static class LinksBean {
                private String self;
                private String share;

                public String getSelf() {
                    return self;
                }

                public void setSelf(String self) {
                    this.self = self;
                }

                public String getShare() {
                    return share;
                }

                public void setShare(String share) {
                    this.share = share;
                }
            }
        }
    }
}
