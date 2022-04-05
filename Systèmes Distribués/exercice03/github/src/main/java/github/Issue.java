package github;

import java.util.List;

public class Issue {
	private Integer id;
    private String title;
    private String body;
    
	
    @Override
	public String toString() {
		return "Issue [id=" + id + ", title=" + title +", body=" + body + "]";
	}

    
	public Issue() {
		super();
	}


	public Issue(Integer id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		//this.labels = labels;
		this.body = body;
	}
    

	public Issue(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
		this.body = "";
		//this.labels = null;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


/*
	public List<String> getLabels() {
		return labels;
	}


	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
*/
	
    
        
}

