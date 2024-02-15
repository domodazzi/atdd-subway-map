package subway.line;

import java.util.Objects;
import subway.common.BusinessException;

public class LineValidator {

  public static void checkSectionForAddition(final Line line, final Section section) {
    // 새로운 구간의 상행역은 해당 노선에 등록되어있는 하행 종점역이어야 한다.
    if (!Objects.equals(line.getDownStationId(), section.getUpStationId())) {
      throw new BusinessException("새로운 구간의 상행역은 해당 노선에 등록되어있는 하행 종점역이어야 합니다.");
    }

    // 이미 해당 노선에 등록되어있는 역은 새로운 구간의 하행역이 될 수 없다.
    line.getSections().stream()
        .filter(it ->
            it.getUpStationId().equals(section.getDownStationId())
                || it.getUpStationId().equals(section.getUpStationId())
        )
        .findAny()
        .ifPresent(station -> {
          throw new BusinessException("이미 해당 노선에 등록되어있는 역은 새로운 구간의 하행역이 될 수 없습니다.");
        });
  }
}
