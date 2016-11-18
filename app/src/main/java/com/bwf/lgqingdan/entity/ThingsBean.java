package com.bwf.lgqingdan.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */

public class ThingsBean {
    private int id;
    private String name;
    private String fullName;
    private String excerpt;
    private String featuredImageUrl;
    private String description;
    private boolean hasDescription;
    private String price;
    private String noBuylinkReason;
    private int imageCount;
    private int buylinkCount;
    private int commentCount;
    private boolean isLiked;
    private int likeCount;
    private boolean isHad;
    private int havingCount;
    private boolean isReviewed;
    private int reviewCount;
    private int hasBodyReviewCount;
    private int ratingScore;
    private boolean showRatingScore;
    private int myRatingValue;
    private int myReviewId;
    private int recommendStatus;
    private String recommendReason;
    /**
     * date : 2016-10-20 16:31:40.000000
     * timezone_type : 3
     * timezone : Asia/Shanghai
     */

    private RecommendedAtBean recommendedAt;
    /**
     * self : http://api.eqingdan.com/v1/things/673
     * html : http://www.eqingdan.com/app/things/673
     * share : http://www.eqingdan.com/mobile/things/673
     * like : http://api.eqingdan.com/v1/thing/673/actions/like
     * cancelLike : http://api.eqingdan.com/v1/thing/673/actions/cancel-like
     */

    private LinksBean links;
    /**
     * name : Kiehl's/科颜氏
     * slug : kiehl-s-ke-yan-shi
     */

    private BrandBean brand;
    /**
     * id : 4
     * username : xiaolu
     * nickname : 小露
     * tagline :
     * avatarUrl : http://img01.eqingdan.com/380cffda-0842-11e5-ad89-00163e002745.jpeg?imageView2/1/w/120/h/120/q/75
     */

    private CreatorBean creator;
    private List<String> imageUrls;
    /**
     * platform : 中国亚马逊
     * price : ￥179
     * link : http://www.amazon.cn/gp/product/B000S97NQW/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=536&creative=3200&creativeASIN=B000S97NQW&linkCode=as2&tag=eqingdan05-23
     */

    private List<BuylinksBean> buylinks;
    /**
     * tagId : 1447
     * name : 化妆水
     * slug : hua-zhuang-shui
     * excerpt : 化妆水在基础护肤中有承前启后的作用，能清洁肌肤、保持肌肤健康、方便后续护理的作用。
     * featuredImageUrl :
     * coverImageUrl : http://img01.eqingdan.com/503a0714-938a-11e5-9c7f-00163e002745.png?imageView2/1/w/640/h/640/q/75
     * thingCount : 62
     * articleCount : 0
     * links : {"wikiHtml":"http://www.eqingdan.com/app/categories/hua-zhuang-shui/wiki","wikiShare":"http://www.eqingdan.com/app/categories/hua-zhuang-shui/wiki","things":"http://api.eqingdan.com/v1/categories/hua-zhuang-shui/things"}
     */

    private List<CategoriesBean> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasDescription() {
        return hasDescription;
    }

    public void setHasDescription(boolean hasDescription) {
        this.hasDescription = hasDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNoBuylinkReason() {
        return noBuylinkReason;
    }

    public void setNoBuylinkReason(String noBuylinkReason) {
        this.noBuylinkReason = noBuylinkReason;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public int getBuylinkCount() {
        return buylinkCount;
    }

    public void setBuylinkCount(int buylinkCount) {
        this.buylinkCount = buylinkCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
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

    public boolean isIsHad() {
        return isHad;
    }

    public void setIsHad(boolean isHad) {
        this.isHad = isHad;
    }

    public int getHavingCount() {
        return havingCount;
    }

    public void setHavingCount(int havingCount) {
        this.havingCount = havingCount;
    }

    public boolean isIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getHasBodyReviewCount() {
        return hasBodyReviewCount;
    }

    public void setHasBodyReviewCount(int hasBodyReviewCount) {
        this.hasBodyReviewCount = hasBodyReviewCount;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public boolean isShowRatingScore() {
        return showRatingScore;
    }

    public void setShowRatingScore(boolean showRatingScore) {
        this.showRatingScore = showRatingScore;
    }

    public int getMyRatingValue() {
        return myRatingValue;
    }

    public void setMyRatingValue(int myRatingValue) {
        this.myRatingValue = myRatingValue;
    }

    public int getMyReviewId() {
        return myReviewId;
    }

    public void setMyReviewId(int myReviewId) {
        this.myReviewId = myReviewId;
    }

    public int getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(int recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason;
    }

    public RecommendedAtBean getRecommendedAt() {
        return recommendedAt;
    }

    public void setRecommendedAt(RecommendedAtBean recommendedAt) {
        this.recommendedAt = recommendedAt;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public BrandBean getBrand() {
        return brand;
    }

    public void setBrand(BrandBean brand) {
        this.brand = brand;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<BuylinksBean> getBuylinks() {
        return buylinks;
    }

    public void setBuylinks(List<BuylinksBean> buylinks) {
        this.buylinks = buylinks;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class RecommendedAtBean {
        private String date;
        private int timezone_type;
        private String timezone;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTimezone_type() {
            return timezone_type;
        }

        public void setTimezone_type(int timezone_type) {
            this.timezone_type = timezone_type;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
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

    public static class BrandBean {
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

    public static class CreatorBean {
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

    public static class BuylinksBean {
        private String platform;
        private String price;
        private String link;

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
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
    }

    public static class CategoriesBean {
        private int tagId;
        private String name;
        private String slug;
        private String excerpt;
        private String featuredImageUrl;
        private String coverImageUrl;
        private int thingCount;
        private int articleCount;
        /**
         * wikiHtml : http://www.eqingdan.com/app/categories/hua-zhuang-shui/wiki
         * wikiShare : http://www.eqingdan.com/app/categories/hua-zhuang-shui/wiki
         * things : http://api.eqingdan.com/v1/categories/hua-zhuang-shui/things
         */

        private LinksBean links;

        public int getTagId() {
            return tagId;
        }

        public void setTagId(int tagId) {
            this.tagId = tagId;
        }

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

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getFeaturedImageUrl() {
            return featuredImageUrl;
        }

        public void setFeaturedImageUrl(String featuredImageUrl) {
            this.featuredImageUrl = featuredImageUrl;
        }

        public String getCoverImageUrl() {
            return coverImageUrl;
        }

        public void setCoverImageUrl(String coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
        }

        public int getThingCount() {
            return thingCount;
        }

        public void setThingCount(int thingCount) {
            this.thingCount = thingCount;
        }

        public int getArticleCount() {
            return articleCount;
        }

        public void setArticleCount(int articleCount) {
            this.articleCount = articleCount;
        }

        public LinksBean getLinks() {
            return links;
        }

        public void setLinks(LinksBean links) {
            this.links = links;
        }

        public static class LinksBean {
            private String wikiHtml;
            private String wikiShare;
            private String things;

            public String getWikiHtml() {
                return wikiHtml;
            }

            public void setWikiHtml(String wikiHtml) {
                this.wikiHtml = wikiHtml;
            }

            public String getWikiShare() {
                return wikiShare;
            }

            public void setWikiShare(String wikiShare) {
                this.wikiShare = wikiShare;
            }

            public String getThings() {
                return things;
            }

            public void setThings(String things) {
                this.things = things;
            }
        }
    }
}