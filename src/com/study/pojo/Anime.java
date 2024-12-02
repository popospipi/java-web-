package com.study.pojo;

public class Anime {

    private int id;
    private String animeName;
    private String originalName;
    private String type;
    private int episodeCount;
    private String startDate;
    private String endDate;
    private String originalWork;
    private String productionCompany;
    private String director;
    private String scriptwriter;
    private String musicDirector;
    private String status;
    private String coverImageUrl;
    private String summary;
    private String music;
    private Double rate;

    // 默认构造函数
    public Anime() {
    }

    // 全参数构造函数
    public Anime(int id, String animeName, String originalName, String type, int episodeCount, String startDate, String endDate,
                 String originalWork, String productionCompany, String director, String scriptwriter, String musicDirector,
                 String status, String coverImageUrl, String summary, String music, Double rate) {
        this.id = id;
        this.animeName = animeName;
        this.originalName = originalName;
        this.type = type;
        this.episodeCount = episodeCount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.originalWork = originalWork;
        this.productionCompany = productionCompany;
        this.director = director;
        this.scriptwriter = scriptwriter;
        this.musicDirector = musicDirector;
        this.status = status;
        this.coverImageUrl = coverImageUrl;
        this.summary = summary;
        this.music = music;
        this.rate = rate;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOriginalWork() {
        return originalWork;
    }

    public void setOriginalWork(String originalWork) {
        this.originalWork = originalWork;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public String getMusicDirector() {
        return musicDirector;
    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
