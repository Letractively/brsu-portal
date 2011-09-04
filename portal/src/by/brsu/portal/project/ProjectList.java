/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.project;

/**
 * @author Artur Smaliuk
 *
 */
public class ProjectList 
{
	private Project project;	

	/**
	 * 
	 */
	public ProjectList() 
	{
		super();
	}
	
	/**
	 * 
	 * 
	 */
	public ProjectList(Project project) 
	{
		super();
		this.project = project;	
	}
	
	/**
	 * @return the project
	 */
	public Project getProject() 
	{
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) 
	{
		this.project = project;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "ProjectList [project=" + project + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectList other = (ProjectList) obj;
		if (project == null) 
		{
			if (other.project != null)
				return false;
		} 
		else if (!project.equals(other.project))
			return false;
		return true;
	}
	
	
}
