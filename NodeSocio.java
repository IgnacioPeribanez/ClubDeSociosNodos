package clubDeSocios;

public class NodeSocio {
	private Socio content;
	private NodeSocio next;
	
	public NodeSocio (Socio content, NodeSocio next) {
		this.content = content;
		this.next = next;
	}

	public Socio getContent() {
		return content;
	}

	public void setContent(Socio content) {
		this.content = content;
	}

	public NodeSocio getNext() {
		return next;
	}

	public void setNext(NodeSocio next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "NodeClub [content=" + content + ", next=" + next + "]";
	}
	
}
