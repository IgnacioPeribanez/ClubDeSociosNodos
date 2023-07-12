package clubDeSocios;

public class NodeClub {
	private Club content;
	private NodeClub next;
	
	public NodeClub (Club content, NodeClub next) {
		this.content = content;
		this.next = next;
	}

	public Club getContent() {
		return content;
	}

	public void setContent(Club content) {
		this.content = content;
	}

	public NodeClub getNext() {
		return next;
	}

	public void setNext(NodeClub next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "NodeClub [content=" + content + ", next=" + next + "]";
	}
	
}
