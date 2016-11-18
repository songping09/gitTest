package com.bwf.lgqingdan.utils;

/**
 * Created by LG on 2016/10/14.
 * Tips:
 */

public interface Apis {
    String API_BASE = "http://api.eqingdan.com/v1/";
    String API_Reputations = API_BASE + "rankings/front";

    String API_TODAY_TIPS = "http://api.eqingdan.com/v1/daily-tips/today";
    String API_ARTICLE_TITLE = "http://api.eqingdan.com/v1/articles/{0}";
    String API_ARTICLE_COMMENTS = "http://api.eqingdan.com/v1/comments/hot?target_type=article&target_id={0}&page=1&per_page=4";
//    String API_ARTICLE_DETAIL = "http://www.eqingdan.com/instance/articles/{0}";
    String API_ARTICLE_DETAIL = "http://www.eqingdan.com/app/articles/{0}";
    /**相关文章-接口**/
    String API_RELATED_ARTICLES = "http://api.eqingdan.com/v1/articles/{0}/related-articles";

    String API_COLLECTION_DETAIL = "http://api.eqingdan.com/v1/batching";
    String API_CHOOSE = "http://api.eqingdan.com/v1/batching";

    String API_REPUTATION_THING_SORT_BY_REVIEW_COUNT = "http://api.eqingdan.com/v1/rankings/{0}/things?keyword={1}&sort=review-count-desc&page={2}&per=10";
    String API_REPUTATION_THING_SORT_BY_rating_score = "http://api.eqingdan.com/v1/rankings/{0}/things?keyword={1}&sort=rating-score-desc&page={2}&per=10";
    String API_REPUTATION_THING_SORT_BY_BRAND_NAME = "http://api.eqingdan.com/v1/rankings/{0}/things?keyword={1}&sort=brand-name-asc&page={2}&per=10";
    String API_ALL_CATEGORY = "http://api.eqingdan.com/v1/categories?depth=3";
    String API_BRIEF_REVIEWS_THING_DETAIL = "http://api.eqingdan.com/v1/reviews?target_type=thing&target_id={0}&has_body=1&sort=hottest&page=1&per=3&include=thing";
    String API_ACTIVLES_THING_DETAIL = "http://api.eqingdan.com/v1/things/{0}/articles";
    String API_REPUTATIONS_LIST = "http://api.eqingdan.com/v1/rankings?page={0}&per=10";
    /**相关商品-接口**/
    String API_RELATED_THING = "http://api.eqingdan.com/v1/articles/{0}/things";

    String API_BUY_LINKS = "http://api.eqingdan.com/v1/things/{0}/buylinks";
}