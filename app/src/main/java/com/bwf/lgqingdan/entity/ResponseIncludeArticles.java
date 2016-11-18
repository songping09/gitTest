package com.bwf.lgqingdan.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 * 商品详情中 收录文章 对应的数据
 */

public class ResponseIncludeArticles {

    /**
     * code : 0
     * message : Success
     * data : {"articles":[{"id":39,"title":"养护口腔健康，除了刷牙还要做什么？","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/e29f8d66-2f7d-11e5-b7ab-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"懒癌患者看完文章可能会哭\u2026\u2026","isLiked":false,"thingCount":5,"likeCount":193,"hitCount":10391,"commentCount":1,"categories":[{"name":"个护","slug":"nursing"}],"publishedAt":"2015-07-22 11:29:01","publishedAtDiffForHumans":"1年前","links":{"self":"http://api.eqingdan.com/v1/articles/39","html":"http://www.eqingdan.com/app/articles/39","share":"http://www.eqingdan.com/mobile/articles/39","like":"http://api.eqingdan.com/v1/article/39/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/39/actions/cancel-like"},"author":{"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":697,"title":"说走就走？其实他准备大半年还赌上了半条命 | 自驾游物品最全清单","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/a623dc50-5878-11e6-abed-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"而立之年的他，独自开车环游中国 21000 公里。心动了是吗？先按照这份清单备好物资吧！","isLiked":false,"thingCount":29,"likeCount":256,"hitCount":41860,"commentCount":12,"categories":[{"name":"出行","slug":"journey"}],"publishedAt":"2016-08-03 17:50:54","publishedAtDiffForHumans":"3月前","links":{"self":"http://api.eqingdan.com/v1/articles/697","html":"http://www.eqingdan.com/app/articles/697","share":"http://www.eqingdan.com/mobile/articles/697","like":"http://api.eqingdan.com/v1/article/697/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/697/actions/cancel-like"},"author":{"id":28516,"username":"aaronliu","nickname":"在远方的阿伦","tagline":"微信公众号：another-sight，2015年单人环游中国21000公里，自驾冒险一直在继续。","avatarUrl":"http://img01.eqingdan.com/7a5198fc-5881-11e6-8a8a-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}]}
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
         * id : 39
         * title : 养护口腔健康，除了刷牙还要做什么？
         * subtitle :
         * featuredImageUrl : http://img01.eqingdan.com/e29f8d66-2f7d-11e5-b7ab-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75
         * excerpt : 懒癌患者看完文章可能会哭……
         * isLiked : false
         * thingCount : 5
         * likeCount : 193
         * hitCount : 10391
         * commentCount : 1
         * categories : [{"name":"个护","slug":"nursing"}]
         * publishedAt : 2015-07-22 11:29:01
         * publishedAtDiffForHumans : 1年前
         * links : {"self":"http://api.eqingdan.com/v1/articles/39","html":"http://www.eqingdan.com/app/articles/39","share":"http://www.eqingdan.com/mobile/articles/39","like":"http://api.eqingdan.com/v1/article/39/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/39/actions/cancel-like"}
         * author : {"id":5,"username":"list","nickname":"李斯特","tagline":"从一个枕头到全世界","avatarUrl":"http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}
         */

        private List<ArticlesBean> articles;

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public static class ArticlesBean {
            private int id;
            private String title;
            private String subtitle;
            private String featuredImageUrl;
            private String excerpt;
            private boolean isLiked;
            private int thingCount;
            private int likeCount;
            private int hitCount;
            private int commentCount;
            private String publishedAt;
            private String publishedAtDiffForHumans;
            /**
             * self : http://api.eqingdan.com/v1/articles/39
             * html : http://www.eqingdan.com/app/articles/39
             * share : http://www.eqingdan.com/mobile/articles/39
             * like : http://api.eqingdan.com/v1/article/39/actions/like
             * cancelLike : http://api.eqingdan.com/v1/article/39/actions/cancel-like
             */

            private LinksBean links;
            /**
             * id : 5
             * username : list
             * nickname : 李斯特
             * tagline : 从一个枕头到全世界
             * avatarUrl : http://img01.eqingdan.com/096c37d8-0796-11e5-908c-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75
             */

            private AuthorBean author;
            /**
             * name : 个护
             * slug : nursing
             */

            private List<CategoriesBean> categories;

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

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getFeaturedImageUrl() {
                return featuredImageUrl;
            }

            public void setFeaturedImageUrl(String featuredImageUrl) {
                this.featuredImageUrl = featuredImageUrl;
            }

            public String getExcerpt() {
                return excerpt;
            }

            public void setExcerpt(String excerpt) {
                this.excerpt = excerpt;
            }

            public boolean isIsLiked() {
                return isLiked;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public int getThingCount() {
                return thingCount;
            }

            public void setThingCount(int thingCount) {
                this.thingCount = thingCount;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getHitCount() {
                return hitCount;
            }

            public void setHitCount(int hitCount) {
                this.hitCount = hitCount;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
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

            public LinksBean getLinks() {
                return links;
            }

            public void setLinks(LinksBean links) {
                this.links = links;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public List<CategoriesBean> getCategories() {
                return categories;
            }

            public void setCategories(List<CategoriesBean> categories) {
                this.categories = categories;
            }

            public static class LinksBean {
                private String self;
                private String html;
                private String share;
                private String like;
                private String cancelLike;

                public String getSelf() {
                    return self;
                }

                public void setSelf(String self) {
                    this.self = self;
                }

                public String getHtml() {
                    return html;
                }

                public void setHtml(String html) {
                    this.html = html;
                }

                public String getShare() {
                    return share;
                }

                public void setShare(String share) {
                    this.share = share;
                }

                public String getLike() {
                    return like;
                }

                public void setLike(String like) {
                    this.like = like;
                }

                public String getCancelLike() {
                    return cancelLike;
                }

                public void setCancelLike(String cancelLike) {
                    this.cancelLike = cancelLike;
                }
            }

            public static class AuthorBean {
                private int id;
                private String username;
                private String nickname;
                private String tagline;
                private String avatarUrl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getTagline() {
                    return tagline;
                }

                public void setTagline(String tagline) {
                    this.tagline = tagline;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }
            }

            public static class CategoriesBean {
                private String name;
                private String slug;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }
            }
        }
    }
}
