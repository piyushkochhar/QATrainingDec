import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListUserRoot {
	public int page;

	@JsonProperty("per_page")
	public int perPage;

	public int total;

	@JsonProperty("total_pages")
	public int totalPages;

	public ArrayList<SingleUserData> data;
	private Support support;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public ArrayList<SingleUserData> getData() {
		return data;
	}

	public void setData(ArrayList<SingleUserData> data) {
		this.data = data;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

}
