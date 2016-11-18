package com.bwf.lgqingdan.entity;

import java.util.List;

public class ResponseMainListData{

    /**
     * code : 0
     * message : Success
     * data : {"nodes":[{"_id":798,"target_type":1,"target_id":836,"target_hash":"","title":"晚睡是种病，这里有药","subtitle":"睡太少会变胖你知道吗？","featuredImageUrl":"http://img01.eqingdan.com/fbb35538-9504-11e6-b83b-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","categories":[{"name":"餐酒","slug":"food-baverage"}],"isLiked":false,"likeCount":31,"commentCount":1,"hitCount":4624,"publishedAt":"2016-10-21 18:19:31","publishedAtDiffForHumans":"1天前"}],"articles":[{"id":791,"title":"那些好用的去油产品，里面其实全是\u201c油\u201d","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/aca11458-8073-11e6-8936-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"原来我每天不止护肤用油，连洗脸都是在用\u201c油\u201d！ ","isLiked":false,"thingCount":4,"likeCount":41,"hitCount":6597,"commentCount":0,"categories":[{"name":"个护","slug":"nursing"}],"publishedAt":"2016-09-22 15:03:37","publishedAtDiffForHumans":"1月前","links":{"self":"http://api.eqingdan.com/v1/articles/791","html":"http://www.eqingdan.com/app/articles/791","share":"http://www.eqingdan.com/mobile/articles/791","like":"http://api.eqingdan.com/v1/article/791/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/791/actions/cancel-like"},"author":{"id":8,"username":"lina","nickname":"Lina","tagline":"理性派剁手党，刀子嘴豆腐心","avatarUrl":"http://img01.eqingdan.com/f60a149a-0780-11e5-a3af-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75","backgroundImageUrl":null,"weibo":null,"wechat":null}}],"collections":[{"_id":69,"id":69,"hash":"kr5y72237381","title":"好衣服更得好好打理 | 衣物护理合辑","subtitle":"看清洗标说明，选对护理工具。","featuredImageUrl":"http://img01.eqingdan.com/1ec4c6ba-11d9-11e6-aae8-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"教你挑干衣机、衣架，还有各类衣物护理方法。","isLiked":false,"likeCount":0,"articleCount":7,"publishedAt":"2016-05-04 17:30:23","publishedAtDiffForHumans":"5月前","links":{"self":"http://api.eqingdan.com/v1/collections/kr5y72237381","share":"http://www.eqingdan.com/mobile/collections/kr5y72237381"}}],"meta":{"pagination":{"total":106,"count":10,"per_page":10,"current_page":1,"total_pages":11,"links":{"next":"http://api.eqingdan.com/v1/collections?page=2"}}}}
     */

    private int code;
    private String message;
    /**
     * nodes : [{"_id":798,"target_type":1,"target_id":836,"target_hash":"","title":"晚睡是种病，这里有药","subtitle":"睡太少会变胖你知道吗？","featuredImageUrl":"http://img01.eqingdan.com/fbb35538-9504-11e6-b83b-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75","categories":[{"name":"餐酒","slug":"food-baverage"}],"isLiked":false,"likeCount":31,"commentCount":1,"hitCount":4624,"publishedAt":"2016-10-21 18:19:31","publishedAtDiffForHumans":"1天前"}]
     * articles : [{"id":791,"title":"那些好用的去油产品，里面其实全是\u201c油\u201d","subtitle":"","featuredImageUrl":"http://img01.eqingdan.com/aca11458-8073-11e6-8936-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"原来我每天不止护肤用油，连洗脸都是在用\u201c油\u201d！ ","isLiked":false,"thingCount":4,"likeCount":41,"hitCount":6597,"commentCount":0,"categories":[{"name":"个护","slug":"nursing"}],"publishedAt":"2016-09-22 15:03:37","publishedAtDiffForHumans":"1月前","links":{"self":"http://api.eqingdan.com/v1/articles/791","html":"http://www.eqingdan.com/app/articles/791","share":"http://www.eqingdan.com/mobile/articles/791","like":"http://api.eqingdan.com/v1/article/791/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/791/actions/cancel-like"},"author":{"id":8,"username":"lina","nickname":"Lina","tagline":"理性派剁手党，刀子嘴豆腐心","avatarUrl":"http://img01.eqingdan.com/f60a149a-0780-11e5-a3af-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75","backgroundImageUrl":null,"weibo":null,"wechat":null}}]
     * collections : [{"_id":69,"id":69,"hash":"kr5y72237381","title":"好衣服更得好好打理 | 衣物护理合辑","subtitle":"看清洗标说明，选对护理工具。","featuredImageUrl":"http://img01.eqingdan.com/1ec4c6ba-11d9-11e6-aae8-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75","excerpt":"教你挑干衣机、衣架，还有各类衣物护理方法。","isLiked":false,"likeCount":0,"articleCount":7,"publishedAt":"2016-05-04 17:30:23","publishedAtDiffForHumans":"5月前","links":{"self":"http://api.eqingdan.com/v1/collections/kr5y72237381","share":"http://www.eqingdan.com/mobile/collections/kr5y72237381"}}]
     * meta : {"pagination":{"total":106,"count":10,"per_page":10,"current_page":1,"total_pages":11,"links":{"next":"http://api.eqingdan.com/v1/collections?page=2"}}}
     */

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
         * pagination : {"total":106,"count":10,"per_page":10,"current_page":1,"total_pages":11,"links":{"next":"http://api.eqingdan.com/v1/collections?page=2"}}
         */

        private MetaBean meta;
        /**
         * _id : 798
         * target_type : 1
         * target_id : 836
         * target_hash :
         * title : 晚睡是种病，这里有药
         * subtitle : 睡太少会变胖你知道吗？
         * featuredImageUrl : http://img01.eqingdan.com/fbb35538-9504-11e6-b83b-00163e004c5e.jpeg?imageView2/1/w/640/h/360/q/75
         * categories : [{"name":"餐酒","slug":"food-baverage"}]
         * isLiked : false
         * likeCount : 31
         * commentCount : 1
         * hitCount : 4624
         * publishedAt : 2016-10-21 18:19:31
         * publishedAtDiffForHumans : 1天前
         */

        private List<NodesBean> nodes;
        /**
         * id : 791
         * title : 那些好用的去油产品，里面其实全是“油”
         * subtitle :
         * featuredImageUrl : http://img01.eqingdan.com/aca11458-8073-11e6-8936-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75
         * excerpt : 原来我每天不止护肤用油，连洗脸都是在用“油”！
         * isLiked : false
         * thingCount : 4
         * likeCount : 41
         * hitCount : 6597
         * commentCount : 0
         * categories : [{"name":"个护","slug":"nursing"}]
         * publishedAt : 2016-09-22 15:03:37
         * publishedAtDiffForHumans : 1月前
         * links : {"self":"http://api.eqingdan.com/v1/articles/791","html":"http://www.eqingdan.com/app/articles/791","share":"http://www.eqingdan.com/mobile/articles/791","like":"http://api.eqingdan.com/v1/article/791/actions/like","cancelLike":"http://api.eqingdan.com/v1/article/791/actions/cancel-like"}
         * author : {"id":8,"username":"lina","nickname":"Lina","tagline":"理性派剁手党，刀子嘴豆腐心","avatarUrl":"http://img01.eqingdan.com/f60a149a-0780-11e5-a3af-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75","backgroundImageUrl":null,"weibo":null,"wechat":null}
         */

        private List<ArticlesBean> articles;
        /**
         * _id : 69
         * id : 69
         * hash : kr5y72237381
         * title : 好衣服更得好好打理 | 衣物护理合辑
         * subtitle : 看清洗标说明，选对护理工具。
         * featuredImageUrl : http://img01.eqingdan.com/1ec4c6ba-11d9-11e6-aae8-00163e002745.jpeg?imageView2/1/w/640/h/360/q/75
         * excerpt : 教你挑干衣机、衣架，还有各类衣物护理方法。
         * isLiked : false
         * likeCount : 0
         * articleCount : 7
         * publishedAt : 2016-05-04 17:30:23
         * publishedAtDiffForHumans : 5月前
         * links : {"self":"http://api.eqingdan.com/v1/collections/kr5y72237381","share":"http://www.eqingdan.com/mobile/collections/kr5y72237381"}
         */

        private List<CollectionsBean> collections;

        public MetaBean getMeta() {
            return meta;
        }

        public void setMeta(MetaBean meta) {
            this.meta = meta;
        }

        public List<NodesBean> getNodes() {
            return nodes;
        }

        public void setNodes(List<NodesBean> nodes) {
            this.nodes = nodes;
        }

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public List<CollectionsBean> getCollections() {
            return collections;
        }

        public void setCollections(List<CollectionsBean> collections) {
            this.collections = collections;
        }

        public static class MetaBean {
            /**
             * total : 106
             * count : 10
             * per_page : 10
             * current_page : 1
             * total_pages : 11
             * links : {"next":"http://api.eqingdan.com/v1/collections?page=2"}
             */

            private PaginationBean pagination;

            public PaginationBean getPagination() {
                return pagination;
            }

            public void setPagination(PaginationBean pagination) {
                this.pagination = pagination;
            }

            public static class PaginationBean {
                private int total;
                private int count;
                private int per_page;
                private int current_page;
                private int total_pages;
                /**
                 * next : http://api.eqingdan.com/v1/collections?page=2
                 */

                private LinksBean links;

                public int getTotal() {
                    return total;
                }

                public void setTotal(int total) {
                    this.total = total;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getPer_page() {
                    return per_page;
                }

                public void setPer_page(int per_page) {
                    this.per_page = per_page;
                }

                public int getCurrent_page() {
                    return current_page;
                }

                public void setCurrent_page(int current_page) {
                    this.current_page = current_page;
                }

                public int getTotal_pages() {
                    return total_pages;
                }

                public void setTotal_pages(int total_pages) {
                    this.total_pages = total_pages;
                }

                public LinksBean getLinks() {
                    return links;
                }

                public void setLinks(LinksBean links) {
                    this.links = links;
                }

                public static class LinksBean {
                    private String next;

                    public String getNext() {
                        return next;
                    }

                    public void setNext(String next) {
                        this.next = next;
                    }
                }
            }
        }

        public static class NodesBean {
            private int _id;
            private int target_type;
            private int target_id;
            private String target_hash;
            private String title;
            private String subtitle;
            private String featuredImageUrl;
            private boolean isLiked;
            private int likeCount;
            private int commentCount;
            private int hitCount;
            private String publishedAt;
            private String publishedAtDiffForHumans;
            /**
             * name : 餐酒
             * slug : food-baverage
             */

            private List<CategoriesBean> categories;

            public int get_id() {
                return _id;
            }

            public void set_id(int _id) {
                this._id = _id;
            }

            public int getTarget_type() {
                return target_type;
            }

            public void setTarget_type(int target_type) {
                this.target_type = target_type;
            }

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_hash() {
                return target_hash;
            }

            public void setTarget_hash(String target_hash) {
                this.target_hash = target_hash;
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

            public boolean isIsLiked() {
                return isLiked;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public int getHitCount() {
                return hitCount;
            }

            public void setHitCount(int hitCount) {
                this.hitCount = hitCount;
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

            public List<CategoriesBean> getCategories() {
                return categories;
            }

            public void setCategories(List<CategoriesBean> categories) {
                this.categories = categories;
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
             * self : http://api.eqingdan.com/v1/articles/791
             * html : http://www.eqingdan.com/app/articles/791
             * share : http://www.eqingdan.com/mobile/articles/791
             * like : http://api.eqingdan.com/v1/article/791/actions/like
             * cancelLike : http://api.eqingdan.com/v1/article/791/actions/cancel-like
             */

            private LinksBean links;
            /**
             * id : 8
             * username : lina
             * nickname : Lina
             * tagline : 理性派剁手党，刀子嘴豆腐心
             * avatarUrl : http://img01.eqingdan.com/f60a149a-0780-11e5-a3af-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75
             * backgroundImageUrl : null
             * weibo : null
             * wechat : null
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
                private Object backgroundImageUrl;
                private Object weibo;
                private Object wechat;

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

                public Object getBackgroundImageUrl() {
                    return backgroundImageUrl;
                }

                public void setBackgroundImageUrl(Object backgroundImageUrl) {
                    this.backgroundImageUrl = backgroundImageUrl;
                }

                public Object getWeibo() {
                    return weibo;
                }

                public void setWeibo(Object weibo) {
                    this.weibo = weibo;
                }

                public Object getWechat() {
                    return wechat;
                }

                public void setWechat(Object wechat) {
                    this.wechat = wechat;
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

        public static class CollectionsBean {
            private int _id;
            private int id;
            private String hash;
            private String title;
            private String subtitle;
            private String featuredImageUrl;
            private String excerpt;
            private boolean isLiked;
            private int likeCount;
            private int articleCount;
            private String publishedAt;
            private String publishedAtDiffForHumans;

            @Override
            public String toString() {
                return "CollectionsBean{" +
                        "_id=" + _id +
                        ", id=" + id +
                        ", hash='" + hash + '\'' +
                        ", title='" + title + '\'' +
                        ", subtitle='" + subtitle + '\'' +
                        ", featuredImageUrl='" + featuredImageUrl + '\'' +
                        ", excerpt='" + excerpt + '\'' +
                        ", isLiked=" + isLiked +
                        ", likeCount=" + likeCount +
                        ", articleCount=" + articleCount +
                        ", publishedAt='" + publishedAt + '\'' +
                        ", publishedAtDiffForHumans='" + publishedAtDiffForHumans + '\'' +
                        ", links=" + links +
                        '}';
            }

            /**
             * self : http://api.eqingdan.com/v1/collections/kr5y72237381
             * share : http://www.eqingdan.com/mobile/collections/kr5y72237381
             */

            private LinksBean links;

            public int get_id() {
                return _id;
            }

            public void set_id(int _id) {
                this._id = _id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
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

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getArticleCount() {
                return articleCount;
            }

            public void setArticleCount(int articleCount) {
                this.articleCount = articleCount;
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