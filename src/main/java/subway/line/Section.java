package subway.line;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Section {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "line_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
  private Line line;

  @Column
  private Long upStationId;

  @Column
  private Long downStationId;

  @Column(nullable = false)
  private int distance;

  protected Section() {
  }

  public Section(
      final Long id,
      final Long upStationId,
      final Long downStationId,
      final int distance,
      final Line line
  ) {
    this.id = id;
    this.upStationId = upStationId;
    this.downStationId = downStationId;
    this.distance = distance;
    this.line = line;
  }

  public Long getId() {
    return id;
  }

  public Long getUpStationId() {
    return upStationId;
  }

  public Long getDownStationId() {
    return downStationId;
  }

  public int getDistance() {
    return distance;
  }

  public void registerLine(final Line line) {
    this.line = line;
  }

}
