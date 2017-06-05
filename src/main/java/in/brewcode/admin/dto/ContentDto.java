package in.brewcode.admin.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ContentDto {

	@Override
	public String toString() {
		return "ContentDto [contentDtoId=" + contentDtoId + ", articleDtoId="
				+ articleDtoId + ", contentDtoBody=" + contentDtoBody
				+ ", contentDtoMediaPath=" + contentDtoMediaPath
				+ ", contentDtoCreatedDate=" + contentDtoCreatedDate
				+ ", contentDtoLastEditedDate=" + contentDtoLastEditedDate
				+ ", isActive=" + isActive + "]";
	}

	private long contentDtoId;

	@NotNull
	private long articleDtoId;
	/*
	 * Tweet html goes here
	 */
	private String contentDtoBody;

	/*
	 * Location string image/gif/video goes here
	 */
	private String contentDtoMediaPath;

	/*
	 * Set via Constructor insert only.
	 */
	private Date contentDtoCreatedDate;
	
	private Date contentDtoLastEditedDate;


	private char isActive;
	
	public long getContentDtoId() {
		return contentDtoId;
	}

	public void setContentDtoId(long contentDtoId) {
		this.contentDtoId = contentDtoId;
	}

	public String getContentDtoBody() {
		return contentDtoBody;
	}

	public void setContentDtoBody(String contentDtoBody) {
		this.contentDtoBody = contentDtoBody;
	}

	public String getContentDtoMediaPath() {
		return contentDtoMediaPath;
	}

	public void setContentDtoMediaPath(String contentDtoMediaPath) {
		this.contentDtoMediaPath = contentDtoMediaPath;
	}

	public Date getContentDtoCreatedDate() {
		return contentDtoCreatedDate;
	}

	public void setContentDtoCreatedDate(Date contentDtoCreatedDate) {
		this.contentDtoCreatedDate = contentDtoCreatedDate;
	}

	public Date getContentDtoLastEditedDate() {
		return contentDtoLastEditedDate;
	}

	public void setContentDtoLastEditedDate(Date contentDtoLastEditedDate) {
		this.contentDtoLastEditedDate = contentDtoLastEditedDate;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public long getArticleDtoId() {
		return articleDtoId;
	}

	public void setArticleDtoId(long articleDtoId) {
		this.articleDtoId = articleDtoId;
	}



	
}
