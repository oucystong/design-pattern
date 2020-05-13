package com.ouc.entity;

public class Shetuan {
    private Integer id;
	private String shetuanbianhao;
	private String shetuanmingcheng;
	private String leibie;
	private String tupian;
	private String dianjilv;
	private String shechang;
	private String shechangxingming;
	private String shetuanjieshao;
	private String issh;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShetuanbianhao() {
        return shetuanbianhao;
    }
    public void setShetuanbianhao(String shetuanbianhao) {
        this.shetuanbianhao = shetuanbianhao == null ? null : shetuanbianhao.trim();
    }
	public String getShetuanmingcheng() {
        return shetuanmingcheng;
    }
    public void setShetuanmingcheng(String shetuanmingcheng) {
        this.shetuanmingcheng = shetuanmingcheng == null ? null : shetuanmingcheng.trim();
    }
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
        this.leibie = leibie == null ? null : leibie.trim();
    }
	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }
	public String getDianjilv() {
        return dianjilv;
    }
    public void setDianjilv(String dianjilv) {
        this.dianjilv = dianjilv == null ? null : dianjilv.trim();
    }
	public String getShechang() {
        return shechang;
    }
    public void setShechang(String shechang) {
        this.shechang = shechang == null ? null : shechang.trim();
    }
	public String getShechangxingming() {
        return shechangxingming;
    }
    public void setShechangxingming(String shechangxingming) {
        this.shechangxingming = shechangxingming == null ? null : shechangxingming.trim();
    }
	public String getShetuanjieshao() {
        return shetuanjieshao;
    }
    public void setShetuanjieshao(String shetuanjieshao) {
        this.shetuanjieshao = shetuanjieshao == null ? null : shetuanjieshao.trim();
    }
	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
