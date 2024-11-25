package QCraft.QCraft.dto.response.interview;

import QCraft.QCraft.commons.ResponseCode;
import QCraft.QCraft.commons.ResponseMessage;
import QCraft.QCraft.domain.Interview;
import QCraft.QCraft.dto.response.member.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GetInterviewListResponseDTO extends ResponseDTO {
    List<InterviewSummaryDTO> data;
    long totalInterviews;

    private GetInterviewListResponseDTO(List<InterviewSummaryDTO> data, Long totalInterviews) {
        super();
        this.data = data;
        this.totalInterviews = totalInterviews;
    }

    public static ResponseEntity<GetInterviewListResponseDTO> success(List<InterviewSummaryDTO> data, Long totalInterviews) {
        GetInterviewListResponseDTO responseDTO = new GetInterviewListResponseDTO(data, totalInterviews);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    public static ResponseEntity<ResponseDTO> interviewNotFound() {
        ResponseDTO responseDTO = new ResponseDTO(ResponseCode.INTERVIEW_NOT_FOUND, ResponseMessage.INTERVIEW_NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    public static ResponseEntity<ResponseDTO> pageRangeOver() {
        ResponseDTO responseDTO = new ResponseDTO(ResponseCode.OUT_OF_RANGE, ResponseMessage.OUT_OF_RANGE);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
