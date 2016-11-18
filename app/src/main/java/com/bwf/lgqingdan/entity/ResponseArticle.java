package com.bwf.lgqingdan.entity;

import java.util.List;

/**
 * Created by LG on 2016/10/28.
 * Tips:
 */

public class ResponseArticle {
    /**
     * code : 0
     * message : Success
     * data : {"comments":[{"id":3160,"target_type":1,"target_id":851,"body":"全智贤好美","rootId":0,"parentId":0,"level":1,"replyCount":0,"isUpvoted":false,"upvoteCount":2,"createdAt":"2016-10-26 20:01:43","createdAtDiffForHumans":"1天前","user":{"id":14971,"username":"seven-en-heng","nickname":"SevenW","tagline":"","avatarUrl":"http://img01.eqingdan.com/ff8afa7e-f2a4-11e5-9a23-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":3181,"target_type":1,"target_id":851,"body":"我把全智贤的动图看了几十遍","rootId":0,"parentId":0,"level":1,"replyCount":0,"isUpvoted":false,"upvoteCount":0,"createdAt":"2016-10-28 09:38:57","createdAtDiffForHumans":"2小时前","user":{"id":12001,"username":"nana-di-si","nickname":"NANA滴斯","tagline":"","avatarUrl":"http://img01.eqingdan.com/0d02011e-d92f-11e5-8c0e-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}],"meta":{"pagination":{"total":2,"count":2,"per_page":4,"current_page":1,"total_pages":1,"links":{}}}}
     */

    private int code;
    private String message;
    /**
     * comments : [{"id":3160,"target_type":1,"target_id":851,"body":"全智贤好美","rootId":0,"parentId":0,"level":1,"replyCount":0,"isUpvoted":false,"upvoteCount":2,"createdAt":"2016-10-26 20:01:43","createdAtDiffForHumans":"1天前","user":{"id":14971,"username":"seven-en-heng","nickname":"SevenW","tagline":"","avatarUrl":"http://img01.eqingdan.com/ff8afa7e-f2a4-11e5-9a23-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}},{"id":3181,"target_type":1,"target_id":851,"body":"我把全智贤的动图看了几十遍","rootId":0,"parentId":0,"level":1,"replyCount":0,"isUpvoted":false,"upvoteCount":0,"createdAt":"2016-10-28 09:38:57","createdAtDiffForHumans":"2小时前","user":{"id":12001,"username":"nana-di-si","nickname":"NANA滴斯","tagline":"","avatarUrl":"http://img01.eqingdan.com/0d02011e-d92f-11e5-8c0e-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}}]
     * meta : {"pagination":{"total":2,"count":2,"per_page":4,"current_page":1,"total_pages":1,"links":{}}}
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
         * pagination : {"total":2,"count":2,"per_page":4,"current_page":1,"total_pages":1,"links":{}}
         */

        private MetaBean meta;
        /**
         * id : 3160
         * target_type : 1
         * target_id : 851
         * body : 全智贤好美
         * rootId : 0
         * parentId : 0
         * level : 1
         * replyCount : 0
         * isUpvoted : false
         * upvoteCount : 2
         * createdAt : 2016-10-26 20:01:43
         * createdAtDiffForHumans : 1天前
         * user : {"id":14971,"username":"seven-en-heng","nickname":"SevenW","tagline":"","avatarUrl":"http://img01.eqingdan.com/ff8afa7e-f2a4-11e5-9a23-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75"}
         */

        private List<CommentsBean> comments;

        public MetaBean getMeta() {
            return meta;
        }

        public void setMeta(MetaBean meta) {
            this.meta = meta;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class MetaBean {
            /**
             * total : 2
             * count : 2
             * per_page : 4
             * current_page : 1
             * total_pages : 1
             * links : {}
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
            }
        }

        public static class CommentsBean {
            private int id;
            private int target_type;
            private int target_id;
            private String body;
            private int rootId;
            private int parentId;
            private int level;
            private int replyCount;
            private boolean isUpvoted;
            private int upvoteCount;
            private String createdAt;
            private String createdAtDiffForHumans;
            /**
             * id : 14971
             * username : seven-en-heng
             * nickname : SevenW
             * tagline :
             * avatarUrl : http://img01.eqingdan.com/ff8afa7e-f2a4-11e5-9a23-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75
             */

            private UserBean user;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getRootId() {
                return rootId;
            }

            public void setRootId(int rootId) {
                this.rootId = rootId;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public boolean isIsUpvoted() {
                return isUpvoted;
            }

            public void setIsUpvoted(boolean isUpvoted) {
                this.isUpvoted = isUpvoted;
            }

            public int getUpvoteCount() {
                return upvoteCount;
            }

            public void setUpvoteCount(int upvoteCount) {
                this.upvoteCount = upvoteCount;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getCreatedAtDiffForHumans() {
                return createdAtDiffForHumans;
            }

            public void setCreatedAtDiffForHumans(String createdAtDiffForHumans) {
                this.createdAtDiffForHumans = createdAtDiffForHumans;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
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
        }
    }
}
