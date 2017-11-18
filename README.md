# HibManyToMany_BiDirectional_App

Only change in this relationship( ManyToMany Bidirectional) and ManyToMany Unidirectional is that, in the Subject class we have added following property.

@ManyToMany(mappedBy="subjects")
private List<Student> students = new ArrayList<Student>();

Nothing else changes.We added this property in Subject class to make the relationship bidirectional.
You can now navigate from Subject to Student.<b>mappedBy</b> attribute tells that this is the inverse side of relationship which is managed by “subjects”
property of Student annotated with @JoinColumn.
